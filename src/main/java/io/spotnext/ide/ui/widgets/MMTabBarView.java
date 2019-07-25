package io.spotnext.ide.ui.widgets;

import ca.weblite.objc.Proxy;
import ca.weblite.objc.annotations.Msg;
import io.spotnext.ide.ui.MMTabBarItem;
import io.spotnext.ide.ui.structs.MMTabBarTearOffStyle;
import io.spotnext.ide.ui.structs.MMTabStyle;
import io.spotnext.kakao.NSObject;
import io.spotnext.kakao.foundation.NSRect;
import io.spotnext.kakao.structs.NSTabViewItem;
import io.spotnext.kakao.ui.NSButton;
import io.spotnext.kakao.ui.NSTabView;
import io.spotnext.kakao.ui.NSView;

public class MMTabBarView extends NSView {
	public MMTabBarView(NSTabView tabView, NSRect frame) {
		super("MMTabBarView", frame);
		setDelegate(this);

		// this is necessary to forward delegate calls to the this delegate
		tabView.setDelegate(this);
	}

	public void setDelegate(MMTabBarView delegate) {
		getNativeHandle().send("setDelegate:", delegate);
	}

	public NSView getPartnerView() {
		var proxy = getNativeHandle().sendProxy("partnerView");
		return NSObject.getInstance(proxy.getPeer());
	}

	public void setPartnerView(NSView view) {
		getNativeHandle().sendBoolean("setPartnerView:", view.getNativeHandle());
	}

	public NSTabView getTabView() {
		var proxy = getNativeHandle().sendProxy("tabView");
		return NSObject.getInstance(proxy.getPeer());
	}

	public void setTabView(NSTabView view) {
		getNativeHandle().sendBoolean("setTabView:", view.getNativeHandle());
	}

	public boolean isOverflowButtonVisible() {
		return getNativeHandle().sendBoolean("overflowButtonVisible");
	}

	public void setTabStyle(MMTabStyle value) {
		getNativeHandle().send("setStyleNamed:", value.id);
	}

	public void setOverflowButtonVisible(boolean value) {
		getNativeHandle().send("setOverflowButtonVisible:", value);
	}

	public void setOnlyShowCloseOnHover(boolean value) {
		getNativeHandle().send("setOnlyShowCloseOnHover:", value);
	}

	public void setCanCloseOnlyTab(boolean value) {
		getNativeHandle().send("setCanCloseOnlyTab:", value);
	}

	public void setDisableTabClose(boolean value) {
		getNativeHandle().send("setDisableTabClose:", value);
	}

	public void setHideForSingleTab(boolean value) {
		getNativeHandle().send("setHideForSingleTab:", value);
	}

	public void setShowAddTabButton(boolean value) {
		getNativeHandle().send("setShowAddTabButton:", value);
	}

	public void setButtonMinWidth(int value) {
		getNativeHandle().send("setButtonMinWidth:", value);
	}

	public void setButtonMaxWidth(int value) {
		getNativeHandle().send("setButtonMaxWidth:", value);
	}

	public void setButtonOptimumWidth(int value) {
		getNativeHandle().send("setButtonOptimumWidth:", value);
	}

	public void setSizeButtonsToFit(boolean value) {
		getNativeHandle().send("setButtonMaxWidth:", value);
	}

	public void setAllowsBackgroundTabClosing(boolean value) {
		getNativeHandle().send("setAllowsBackgroundTabClosing:", value);
	}

	public void setAllowsResizing(boolean value) {
		getNativeHandle().send("setAllowsResizing:", value);
	}

	public void setSelectsTabsOnMouseDown(boolean value) {
		getNativeHandle().send("setSelectsTabsOnMouseDown:", value);
	}

	public void setAutomaticallyAnimates(boolean value) {
		getNativeHandle().send("setAutomaticallyAnimates:", value);
	}

	public void setAlwaysShowActiveTab(boolean value) {
		getNativeHandle().send("setAlwaysShowActiveTab:", value);
	}

	public void setAllowsScrubbing(boolean value) {
		getNativeHandle().send("setAllowsScrubbing:", value);
	}

	public void setTearOffStyle(MMTabBarTearOffStyle value) {
		getNativeHandle().send("setTearOffStyle:", value.id);
	}

	public NSButton getTabButtonForIdentifier(NSObject identifier) {
		var proxy = getNativeHandle().sendProxy("tabButtonForIdentifier:", identifier);

		return new NSButton(proxy);
	}

	@Msg(selector = "tabView:didSelectTabViewItem:", signature = "v@:@@")
	public void tabViewDidSelectTabViewItem(Proxy tabView, Proxy tabViewItem) {
		var nsTabBar = (NSTabView) NSObject.getInstance(tabView.getPeer());
		var nsTabViewItem = (NSTabViewItem) NSObject.getInstance(tabViewItem.getPeer());

		var mmtabBar = (MMTabBarView) nsTabBar.getDelegate();

//		mmtabBar.getTabButtonForIdentifier(nsTabViewItem.getIdentifier());

		var subviews = mmtabBar.getSubViews();

		var identifier = nsTabViewItem.getIdentifier();

		if (identifier instanceof MMTabBarItem) {
			var title = ((MMTabBarItem) identifier).getTitle();
			nsTabViewItem.setLabel(title);
		}
	}

	public void selectTabViewItem(NSTabViewItem item) {
		getNativeHandle().send("selectTabViewItem:", item.getNativeHandle());
	}
	
	@Override
	public void refresh() {
		super.refresh();
		getNativeHandle().send("setNeedsUpdate:", true);
	}
	
}
