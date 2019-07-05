package io.spotnext.ide.project.impl;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.building.DefaultModelBuilderFactory;
import org.apache.maven.model.building.DefaultModelBuildingRequest;
import org.apache.maven.project.DefaultProjectBuilder;
import org.apache.maven.project.DefaultProjectBuildingRequest;
import org.apache.maven.project.MavenProject;

import io.spotnext.ide.project.Project;

public class JavaProject implements Project {

	private final MavenProject mavenProject;
	private Model model;

	public JavaProject(String projectFile) {
		var factory = new DefaultModelBuilderFactory();

		var pomFile = new File(projectFile);
		var request = new DefaultModelBuildingRequest();
		request.setPomFile(pomFile);

		try {
			var projectBuildingRequest = new DefaultProjectBuildingRequest();
			projectBuildingRequest.setProcessPlugins(false);

			var projectBuilder = new DefaultProjectBuilder();
//			var buildingHelper = new DefaultProjectBuildingHelper();
//			ClassUtil.setField(projectBuilder, "projectBuildingHelper", buildingHelper);
//			ClassUtil.setField(projectBuilder, "modelBuilder", factory.newInstance());

//			var result = projectBuilder.build(pomFile, projectBuildingRequest);
			this.model = factory.newInstance().build(request).getEffectiveModel();

//			var artifact = new DefaultArtifact(model.getGroupId(), model.getArtifactId(), model.getVersion(), "compile", "jar", "", new DefaultArtifactHandler());
//			var result = projectBuilder.build(artifact, projectBuildingRequest);

//			mavenProject = new MavenProject(model);
//			mavenProject = result.getProject();
			mavenProject = new FakeMavenProject(model);
		} catch (Exception e) {
			throw new IllegalStateException("Cannot load maven project", e);
		}
	}

	@Override
	public List<String> getSourceRoots() {
		return mavenProject.getCompileSourceRoots();
	}

	@Override
	public void setName(String title) {
		mavenProject.setName(title);
	}

	@Override
	public String getName() {
		return mavenProject.getName();
	}

	@Override
	public String getVersion() {
		return mavenProject.getVersion();
	}

	@Override
	public void setVersion(String version) {
		mavenProject.setVersion(version);
	}

	@Override
	public List<Dependency> getDependencies() {
		return model.getDependencies();
	}

	public static class FakeMavenProject extends MavenProject {
		private Model model;

		public FakeMavenProject(Model model) {
			this.model = model;
		}

		@Override
		public List<String> getCompileSourceRoots() {
			return Arrays.asList(model.getBuild().getSourceDirectory());
		}

		@Override
		public String getName() {
			return model.getName();
		}

		@Override
		public String getGroupId() {
			return model.getGroupId();
		}

		@Override
		public String getArtifactId() {
			return model.getArtifactId();
		}

		@Override
		public String getVersion() {
			return model.getVersion();
		}
	}

	@Override
	public List<String> getTestSourceRoots() {
		return Arrays.asList(model.getBuild().getTestSourceDirectory());
	}

	@Override
	public List<String> getResourceRoots() {
		return model.getBuild().getResources().stream().map(r -> r.getDirectory()).collect(Collectors.toList());
	}

	@Override
	public List<String> getTestResourceRoots() {
		return model.getBuild().getTestResources().stream().map(r -> r.getDirectory()).collect(Collectors.toList());
	}
}
