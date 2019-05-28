package io.spotnext.ide.ui.views;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

import at.int32.sweaty.ui.Control;
import at.int32.sweaty.ui.Grid;
import at.int32.sweaty.ui.View;

public class MainView extends View {

	private Grid rootGrid;
	
	public MainView(Control parent) {
		super(parent);
	}

	@Override
	public void onInit() {
		rootGrid = new Grid(this);
		
//		var sourceList = new SourceList(rootGrid.ctrl(), 0);
		
		var tabFolder = new CTabFolder(rootGrid.ctrl(), 0);
		tabFolder.setHighlightEnabled(false);
		tabFolder.setSimple(true);

		var item = new CTabItem(tabFolder, 0);
		item.setText("test");
		
//		var itemLabel = new CLabel(item, 0);
//		itemLabel.setText("Test");
		
		var item2 = new CTabItem(tabFolder, 0);
		item2.setText("test 2");
	}

}
