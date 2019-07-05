package io.spotnext.ide.project;

import java.util.List;

import org.apache.maven.model.Dependency;

public interface Project {

	void setName(String title);

	String getName();

	String getVersion();
	
	void setVersion(String version);

	List<String> getSourceRoots();
	
	List<String> getTestSourceRoots();
	
	List<String> getResourceRoots();
	
	List<String> getTestResourceRoots();
	
	List<Dependency> getDependencies();
}
