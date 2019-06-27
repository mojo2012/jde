package io.spotnext.ide.project;

import java.util.List;

public interface Project {

	void setName(String title);

	String getName();

	String getVersion();
	
	void setVersion(String version);

	List<String> getSourceRoots();
}
