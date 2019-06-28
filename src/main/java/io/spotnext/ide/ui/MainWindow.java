package io.spotnext.ide.ui;

import io.spotnext.ide.Application.ExplorerNode;
import io.spotnext.ide.Application.ProjectExplorerData;
import io.spotnext.kakao.foundation.NSPoint;
import io.spotnext.kakao.foundation.NSRect;
import io.spotnext.kakao.foundation.NSSize;
import io.spotnext.kakao.structs.DataGroupNode;
import io.spotnext.kakao.structs.DataLeafNode;
import io.spotnext.kakao.structs.DataNode;
import io.spotnext.kakao.structs.NSAutoresizingMaskOptions;
import io.spotnext.kakao.structs.NSFocusRingType;
import io.spotnext.kakao.structs.NSImageName;
import io.spotnext.kakao.structs.NSSplitViewDividerStyle;
import io.spotnext.kakao.structs.NSWindowTitleVisibility;
import io.spotnext.kakao.structs.Orientation;
import io.spotnext.kakao.structs.SelectionHighlightStyle;
import io.spotnext.kakao.support.NSOutlineViewDataSource;
import io.spotnext.kakao.support.NSOutlineViewDelegate;
import io.spotnext.kakao.ui.NSButton;
import io.spotnext.kakao.ui.NSClipView;
import io.spotnext.kakao.ui.NSOutlineView;
import io.spotnext.kakao.ui.NSScrollView;
import io.spotnext.kakao.ui.NSSearchField;
import io.spotnext.kakao.ui.NSSplitView;
import io.spotnext.kakao.ui.NSTableColumn;
import io.spotnext.kakao.ui.NSTextField;
import io.spotnext.kakao.ui.NSToolbar;
import io.spotnext.kakao.ui.NSToolbarItem;
import io.spotnext.kakao.ui.NSWindow;

public class MainWindow {

	private final NSWindow window;
	private NSOutlineView sidebar;

	public MainWindow() {
		var windowSize = new NSSize(1200, 800);

		window = new NSWindow(new NSRect(new NSPoint(-1, -1), windowSize));
		window.setTitle("JDE");
		window.setTitleVisibility(NSWindowTitleVisibility.Hidden);
		window.setToolbar(createToolbar());
		window.setMinSize(windowSize);

		createSplitPane(window);

		window.center();
	}

	private void createSplitPane(NSWindow window) {
		var bounds = window.contentViewFrame();

		var splitView = new NSSplitView(bounds);
		splitView.setDividerStyle(NSSplitViewDividerStyle.Thin);
		splitView.setOrientation(Orientation.Vertical);

		splitView.getDividerStyle();

		var sidebarX = 0;
		var sidebarY = 0;
		var sidebarWidth = 250d;
		var sidebarHeight = bounds.size.height.doubleValue();

		sidebar = new NSOutlineView();
		sidebar.setSelectionHighlightStyle(SelectionHighlightStyle.SourceList);

		var col1 = new NSTableColumn("Content");
		col1.setEditable(false);
		col1.getHeaderCell().setStringValue("Content");
		sidebar.addTableColumn(col1);
		sidebar.setOutlineTableColumn(col1);
		sidebar.setTableHeaderView(null);

		sidebar.setDelegate(new NSOutlineViewDelegate() {
		});

		var sidebarRect = new NSRect(sidebarX, sidebarY, sidebarWidth, sidebarHeight);
		var clipView = new NSClipView();
		clipView.setAutoresizesSubviews(true);
		clipView.setDocumentView(sidebar);

		var sidebarScrollView = new NSScrollView(sidebarRect);
		sidebarScrollView.setContentView(clipView);
//		sidebarScrollView.setAutoresizingMask(NSAutoresizingMaskOptions.MaxXMargin);

		var textFieldX = sidebarX + sidebarWidth;
		var textFieldY = sidebarY;
		var textFieldWidth = bounds.size.width.doubleValue() - sidebarWidth;
		var textFieldHeight = sidebarHeight;

		var textField = new NSTextField(new NSRect(textFieldX, textFieldY, textFieldWidth, textFieldHeight));
		textField.setFocusRingType(NSFocusRingType.None);
		textField.setBordered(false);

		splitView.addSubview(sidebarScrollView);
		splitView.addSubview(textField);

		// why can't I pass 200?
//		splitView.setPosition(20d, 0);
		splitView.adjustSubviews();
		splitView.setAutoresizingMask(NSAutoresizingMaskOptions.HeightSizable, NSAutoresizingMaskOptions.WidthSizable);
//		splitView.setHoldingPriorityForSubview(490, 0);

		window.addSubview(splitView);
	}

	public NSToolbar createToolbar() {
		var toolbar = new NSToolbar();

		int itemIndex = 0;

		var runButtonItem = new NSToolbarItem("runButtonItem");
		runButtonItem.setLabel("Run");
		runButtonItem.setToolTip("Build and then run the current application");

		var runButton = new NSButton(NSImageName.GoRight);
		runButton.setFrameSize(NSSize.of(50, 0));
		runButtonItem.setView(runButton);
		toolbar.insertItem(runButtonItem, itemIndex++);

		var stopButtonItem = new NSToolbarItem("stopButtonItem");
		stopButtonItem.setLabel("Stop");
		stopButtonItem.setToolTip("Stop the current application");
		stopButtonItem.setEnabled(false);
		var stopButton = new NSButton(NSImageName.GoLeft);
		stopButton.setFrameSize(NSSize.of(50, 0));
		stopButtonItem.setView(stopButton);
		stopButton.setEnabled(false);
		toolbar.insertItem(stopButtonItem, itemIndex++);

//		var segControl = new NSSegmentedControl(new NSRect(0, 0, 200, 40));
//		segControl.setSegmentCount(2);
//		segControl.setLabel("Segment 1", 0);
//		segControl.setLabel("Segment 2", 1);
//		segControl.setSelected(0);

//		var runStopButtonGroup = new NSToolbarItem("runStopButtonGroup");
//		runStopButtonGroup.setLabel("Run/Stop");
//		runStopButtonGroup.setView(segControl);
//		toolbar.insertItem(runStopButtonGroup, itemIndex++);

		var flexSpacer = NSToolbarItem.FLEXIBLE_SPACER;
		flexSpacer.setVisible(true);
		toolbar.insertItem(flexSpacer, itemIndex++);

		var searchFieldItem = new NSToolbarItem("searchFieldItem");
		searchFieldItem.setLabel("Search");
		searchFieldItem.setToolTip("Search");
		searchFieldItem.setView(new NSSearchField());
		toolbar.insertItem(searchFieldItem, itemIndex++);

		var spacer = NSToolbarItem.FIXED_SPACER;
		spacer.setVisible(false);
		toolbar.insertItem(spacer, itemIndex++);

		var separator = NSToolbarItem.SEPARATOR;
		separator.setVisible(false);
		toolbar.insertItem(separator, itemIndex++);

		return toolbar;
	}

	public void show() {
		window.makeKeyAndOrderFront(null);
	}

	public void setupExplorer(ProjectExplorerData projectExplorerData) {
		var root = new DataGroupNode("root");

		for (var node : projectExplorerData.getNodes()) {
			var n = createNode(node);
			root.addNodes(n);
		}

		sidebar.setDataSource(new NSOutlineViewDataSource(root) {
		});

	}

	private DataNode createNode(ExplorerNode node) {
		final DataNode dataNode;

		if (node.getNodes().size() > 0) {
			var dataGroupNode = new DataGroupNode(node.getName());
			dataNode = dataGroupNode;

			for (var subNode : node.getNodes()) {
				dataGroupNode.addNodes(createNode(subNode));
			}
		} else {
			dataNode = new DataLeafNode(node.getName());
		}

		return dataNode;
	}
}