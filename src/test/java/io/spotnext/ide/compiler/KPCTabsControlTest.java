package io.spotnext.ide.compiler;

import static org.junit.Assert.assertTrue;

import ca.weblite.objc.Client;
import io.spotnext.ide.Application;
import io.spotnext.kakao.foundation.NSRect;
import io.spotnext.kakao.support.NSBundle;

public class KPCTabsControlTest {

	@org.junit.jupiter.api.Test
	public void test() {
		var kpcTabsBundle = new NSBundle("/frameworks/MMTabBarView.framework", Application.class);
		
		assertTrue(kpcTabsBundle.isLoaded());

		var c = Client.getInstance();
		var proxy = c.sendProxy("MMTabBarView", "alloc");
		proxy.sendProxy("initWithFrame:", NSRect.DEFAULT);

	}
}
