package io.spotnext.ide;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.spotnext.ide.project.Project;
import io.spotnext.ide.project.impl.JavaProject;
import io.spotnext.ide.ui.MainWindow;
import io.spotnext.kakao.NSApplication;
import io.spotnext.kakao.util.ThreadUtil;

public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

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
			var sourceRoot = new ExplorerNode("Sources");
			nodes.add(sourceRoot);

			for (var s : project.getSourceRoots()) {
				sourceRoot.addNode(readDirectory(s));
			}
		}

		private ExplorerNode readDirectory(String filePath) {
			var sourceDir = new ExplorerNode(filePath);
			
			return sourceDir;
		}
	}

	public static class ExplorerNode {
		private final String name;
		private final List<ExplorerNode> nodes = new ArrayList<>();

		public ExplorerNode(String name) {
			this.name = name;
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

	}
}
