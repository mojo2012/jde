package io.spotnext.ide.ui.structs;

public enum MMTabStyle {
	Aqua("Aqua"),
	Unified("Unified"),
	Adium("Adium"),
	Metal("Metal"),
	Mojave("Mojave"),
	Card("Card"),
	LiveChat("LiveChat"),
	Safari("Safari"),
	Yosemite("Yosemite"),
	;

	public final String id;

	private MMTabStyle(String id) {
		this.id = id;
	}
}
