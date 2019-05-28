package io.spotnext.ide;

import io.spotnext.ide.ui.MainWindow;

public class Application extends at.int32.sweaty.ui.Application {

	private final MainWindow mainWindow;

	public static void main(String... args) {
		new Application();
	}

	private Application() {
		mainWindow = new MainWindow("JDE");
		mainWindow.show();
		setAppName("JDE");
	}
}
