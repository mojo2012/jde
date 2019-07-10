package io.spotnext.ide.infrastructure;

import java.util.ArrayList;

import io.spotnext.ide.project.Project;

public class LanguageServer {

	private Project project;

	public LanguageServer(Project project) {
		this.project = project;
	}
	
//	-Declipse.application=org.eclipse.jdt.ls.core.id1 -Dosgi.bundles.defaultStartLevel=4 
//	-Declipse.product=org.eclipse.jdt.ls.core.product -Dlog.level=ALL -noverify -Xmx1G -jar 
//	./plugins/org.eclipse.equinox.launcher_1.5.500.v20190620-1700.jar -configuration ./config_mac 
//	-data /var/tmp/my-app --add-modules=ALL-SYSTEM --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED
	
	public void start() {
		var arguments = new ArrayList<>();
		
		// for debugging
		arguments.add("-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=1044e");
		arguments.add("-Declipse.application=org.eclipse.jdt.ls.core.id1");
		arguments.add("-Dosgi.bundles.defaultStartLevel=4");
		arguments.add("-Declipse.product=org.eclipse.jdt.ls.core.product");
		arguments.add("-Dlog.level=ALL");
		arguments.add("-noverify");
		arguments.add("-Xmx1G");
		arguments.add("-jar ./plugins/org.eclipse.equinox.launcher_1.5.500.v20190620-1700.jar");
		arguments.add("-configuration ./config_mac ");
		arguments.add("--data " + project.getRootPath().toString());
		arguments.add("--add-modules=ALL-SYSTEM");
		arguments.add("--add-opens java.base/java.util=ALL-UNNAMED");
		arguments.add("--add-opens java.base/java.lang=ALL-UNNAMED");
	}
}
