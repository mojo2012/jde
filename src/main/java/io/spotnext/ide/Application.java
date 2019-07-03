package io.spotnext.ide;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.spotnext.ide.project.Project;
import io.spotnext.ide.project.impl.JavaProject;
import io.spotnext.ide.ui.MainWindow;
import io.spotnext.kakao.NSApplication;
import io.spotnext.kakao.util.ThreadUtil;

public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	private static final List<Pattern> FILE_PATTERNS_TO_EXCLUDE = new ArrayList<>();
	
	static {
		FILE_PATTERNS_TO_EXCLUDE.add(Pattern.compile("\\.DS_Store"));
	}

	private final Project project;

	public static void main(String... args) {
		var app = new Application("/Users/matthias/Projekte/spOt/jfly/pom.xml");
		app.run();
	}

	public Application(String projectFile) {
		this.project = new JavaProject(projectFile);
	}

	public void run() {
		ThreadUtil.performOnMainThread(() -> {
			final var app = NSApplication.sharedApplication();
			app.setApplicationIconImage("/Applications/Development/Eclipse.app/Contents/Resources/Eclipse.icns");
			app.setApplicationName("JDE");
			app.setApplicationShouldTerminateAfterLastWindowClosed(true);

			final var window = new MainWindow();

			app.onApplicationDidFinishLaunching(p -> {
				app.activateIgnoringOtherApps(true);
				window.setupExplorer(new ProjectExplorerData(project));
				window.show();
			});

			app.run();
		});
	}

	public static class ProjectExplorerData {
		private final List<ExplorerNode> nodes = new ArrayList<>();

		public ProjectExplorerData(Project project) {
			nodes.add(createFileRootNodes("Sources", project.getSourceRoots()));
			nodes.add(createFileRootNodes("Resources", project.getResourceRoots()));
			nodes.add(createFileRootNodes("TestSources", project.getTestSourceRoots()));
			nodes.add(createFileRootNodes("TestResources", project.getTestResourceRoots()));

			var dependenciesRoot = new ExplorerNode("Dependencies", true);
			nodes.add(dependenciesRoot);

//			for (var s : project.getSourceRoots()) {
//				dependenciesRoot.addNode(readDirectory(s));
//			}
		}

		private ExplorerNode createFileRootNodes(String name, List<String> baseDirectories) {
			var node = new ExplorerNode(name, true);

			for (var s : baseDirectories) {
				node.addNode(createFileNode(s));
			}

			return node;
		}

		private ExplorerNode createFileNode(String filePath) {
			final var file = new File(filePath);
			final var node = new ExplorerFileNode(file.getName(), filePath, FilenameUtils.getExtension(file.getName()));

			if (file.isDirectory()) {
				for (var l : file.list()) {
					if (FILE_PATTERNS_TO_EXCLUDE.stream().noneMatch(p -> p.matcher(l).matches())) {
						node.addNode(createFileNode(Paths.get(filePath, l).toAbsolutePath().toString()));
					}
				}
			}

			return node;
		}

		public List<ExplorerNode> getNodes() {
			return nodes;
		}

	}

	public static class ExplorerNode {
		private final String name;
		private final String filePath;
		private final boolean isGroupHeader;
		private final List<ExplorerNode> nodes = new ArrayList<>();

		public ExplorerNode(String name, String filePath) {
			this.name = name;
			this.filePath = filePath;
			this.isGroupHeader = false;
		}

		public ExplorerNode(String name, boolean isGroupHeader) {
			this.name = name;
			this.filePath = null;
			this.isGroupHeader = isGroupHeader;
		}

		public void addNode(ExplorerNode node) {
			nodes.add(node);
		}

		public List<ExplorerNode> getNodes() {
			return nodes;
		}

		public String getName() {
			return name;
		}

		public boolean isFile() {
			return this.filePath != null;
		}

		public String getFilePath() {
			return filePath;
		}

		public boolean isGroupHeader() {
			return isGroupHeader;
		}

	}

	public static class ExplorerFileNode extends ExplorerNode {
		private String filePath;
		private String fileExtension;

		public ExplorerFileNode(String name, String filePath, String extension) {
			super(name, filePath);
			this.filePath = filePath;
			this.fileExtension = extension;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public String getFileExtension() {
			return fileExtension;
		}

		public void setFileExtension(String fileExtension) {
			this.fileExtension = fileExtension;
		}

	}
}
