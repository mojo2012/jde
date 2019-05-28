package io.spotnext.ide.resources;

import org.eclipse.swt.graphics.Image;

import at.int32.sweaty.ui.utils.ImageUtils;

public class Images {

	public static final String imgPath = "/images/";
	public static final Image TOOLBAR_SAVE = ImageUtils.getImageFromResources(imgPath + "save.png");
	public static final Image TOOLBAR_EDIT = ImageUtils.getImageFromResources(imgPath + "edit.png");
	public static final Image TOOLBAR_DELETE = ImageUtils.getImageFromResources(imgPath + "delete.png");
	public static final Image trayIcon = ImageUtils.getImageFromResources(imgPath + "tray.png");
}
