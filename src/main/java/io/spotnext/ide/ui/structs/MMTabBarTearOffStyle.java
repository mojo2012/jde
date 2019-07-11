package io.spotnext.ide.ui.structs;

public enum MMTabBarTearOffStyle {
	AlphaWindow(0), MiniWindow(1),;

	public final long id;

	private MMTabBarTearOffStyle(long id) {
		this.id = id;
	}
}
