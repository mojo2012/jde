package io.spotnext.cocoa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import ca.weblite.objc.Client;
import ca.weblite.objc.Proxy;

public class ExternalFrameworkTest  {
	@Test
	public void test() {
		Client c = Client.getInstance();
		Proxy bundle = c.sendProxy("NSBundle", "bundleWithPath:", "/Users/matthias.fuchs/Projekte/privat/jde/src/main/resources/frameworks/ACEView.framework");
		boolean loaded = bundle.sendBoolean("load");
		
		assertNotNull(bundle);
		assertTrue(loaded);
		
		var aceViewClass = bundle.send("classNamed:", "ACEView");
		
		var aceView = c.sendProxy("ACEView", "alloc");
		
	}
}
