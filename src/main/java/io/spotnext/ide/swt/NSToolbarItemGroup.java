package io.spotnext.ide.swt;

import org.eclipse.swt.internal.cocoa.NSObject;
import org.eclipse.swt.internal.cocoa.NSView;

//https://christiantietze.de/posts/2016/06/segmented-nstoolbaritem/
public class NSToolbarItemGroup extends NSObject {
	NSView view;
	
	public NSToolbarItemGroup(long /*int*/ id) {
		super(id);
		this.view = (NSView) new NSSegmentedControl().init().alloc();
	}
}
