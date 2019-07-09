package io.spotnext.ide.resources;

import io.spotnext.kakao.structs.NSImage;

public interface Images {
	public static final String BASE_PATH = "/images/";

	public interface FileTypes {
		public static final String BASE_PATH = Images.BASE_PATH + "/filetypes/";

		public static final NSImage GENERIC_CODE_FILE = new NSImage(BASE_PATH + "code.png");
		public static final NSImage GENERIC_CONFIG_FILE = new NSImage(BASE_PATH + "config.png");
		public static final NSImage GENERIC_DEPENDENCY = new NSImage(BASE_PATH + "dependency.icns");
		public static final NSImage GENERIC_FOLDER_CLOSED = new NSImage(BASE_PATH + "folder_closed.png");
		public static final NSImage GENERIC_FOLDER_OPEN = new NSImage(BASE_PATH + "folder_open.png");

	}

	public interface Toolbar {
		public static final String BASE_PATH = Images.BASE_PATH + "/toolbar/";

		public static final NSImage RUN = new NSImage(BASE_PATH + "run.png");
		public static final NSImage STOP = new NSImage(BASE_PATH + "stop.png");
		public static final NSImage COMPILE = new NSImage(BASE_PATH + "compile.png");
	}

}
