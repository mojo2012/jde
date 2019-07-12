package io.spotnext.ide.ui;

import ca.weblite.objc.annotations.Msg;
import io.spotnext.kakao.NSObject;
import io.spotnext.kakao.structs.NSImage;
import io.spotnext.kakao.structs.NSNumber;
import io.spotnext.kakao.support.NSCopying;

public class MMTabBarItem extends NSObject implements NSCopying {

	private String title;
	private NSImage icon;
	private String iconName;
	private NSImage largeImage;
	private boolean isProcessing;
	private Integer objectCount;
	private NSObject objectCountColor;
	private boolean isEdited;
	private boolean hasCloseButton;

	public MMTabBarItem() {
		super("NSObject", true);
	}

	@Msg(selector = "title", signature = "@@:")
	public String getTitle() {
		return title;
	}

	@Msg(selector = "setTitle:", signature = "v@:@")
	public void setTitle(String title) {
		this.title = title;
	}

	@Msg(selector = "icon", signature = "@@:")
	public NSImage getIcon() {
		return icon;
	}

	@Msg(selector = "setIcon:", signature = "v@:@")
	public void setIcon(NSImage icon) {
		this.icon = icon;
	}

	@Msg(selector = "iconName", signature = "@@:")
	public String getIconName() {
		return iconName;
	}

	@Msg(selector = "setIconName:", signature = "v@:@")
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	@Msg(selector = "largeImage", signature = "@@:")
	public NSImage getLargeImage() {
		return largeImage;
	}

	@Msg(selector = "setLargeImage:", signature = "v@:@")
	public void setLargeImage(NSImage largeImage) {
		this.largeImage = largeImage;
	}

	@Msg(selector = "isProcessing", signature = "c@:")
	public boolean isProcessing() {
		return isProcessing;
	}

	@Msg(selector = "setIsProcessing:", signature = "v@:c")
	public void setProcessing(boolean isProcessing) {
		this.isProcessing = isProcessing;
	}

	@Msg(selector = "objectCount", signature = "@@:")
	public int getObjectCount() {
		return objectCount;
	}

	@Msg(selector = "setObjectCount:", signature = "v@:@")
	public void setObjectCount(Integer objectCount) {
		this.objectCount = objectCount;
	}

	@Msg(selector = "objectCountColor", signature = "@@:")
	public NSObject getObjectCountColor() {
		return objectCountColor;
	}

	@Msg(selector = "setObjectCountColor:", signature = "v@:@")
	public void setObjectCountColor(NSObject objectCountColor) {
		this.objectCountColor = objectCountColor;
	}

	@Msg(selector = "isEdited", signature = "c@:")
	public boolean isEdited() {
		return isEdited;
	}

	@Msg(selector = "setIsEdited:", signature = "v@:c")
	public void setEdited(boolean isEdited) {
		this.isEdited = isEdited;
	}

	@Msg(selector = "hasCloseButton", signature = "c@:")
	public boolean hasCloseButton() {
		return hasCloseButton;
	}

	@Msg(selector = "setHasCloseButton:", signature = "v@:c")
	public void setHasCloseButton(boolean hasCloseButton) {
		this.hasCloseButton = hasCloseButton;
	}

	@Override
	@Msg(selector = "copyWithZone", signature = "@@:")
	public NSObject copyWithZone() {
		return this;
	}
}
