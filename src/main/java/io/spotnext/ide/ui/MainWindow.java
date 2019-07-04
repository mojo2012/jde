package io.spotnext.ide.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import ca.weblite.objc.Proxy;
import ca.weblite.objc.annotations.Msg;
import io.spotnext.ide.Application.ExplorerNode;
import io.spotnext.ide.Application.ProjectExplorerData;
import io.spotnext.kakao.foundation.NSPoint;
import io.spotnext.kakao.foundation.NSRect;
import io.spotnext.kakao.foundation.NSSize;
import io.spotnext.kakao.structs.DataGroupNode;
import io.spotnext.kakao.structs.DataLeafNode;
import io.spotnext.kakao.structs.DataNode;
import io.spotnext.kakao.structs.NSAutoresizingMaskOptions;
import io.spotnext.kakao.structs.NSData;
import io.spotnext.kakao.structs.NSFocusRingType;
import io.spotnext.kakao.structs.NSImage;
import io.spotnext.kakao.structs.NSSplitViewDividerStyle;
import io.spotnext.kakao.structs.NSTableViewRowSizeStyle;
import io.spotnext.kakao.structs.NSWindowTitleVisibility;
import io.spotnext.kakao.structs.Orientation;
import io.spotnext.kakao.structs.SelectionHighlightStyle;
import io.spotnext.kakao.support.NSFont;
import io.spotnext.kakao.support.NSOutlineViewDataSource;
import io.spotnext.kakao.support.NSOutlineViewDelegate;
import io.spotnext.kakao.ui.NSButton;
import io.spotnext.kakao.ui.NSClipView;
import io.spotnext.kakao.ui.NSOutlineView;
import io.spotnext.kakao.ui.NSScrollView;
import io.spotnext.kakao.ui.NSSearchField;
import io.spotnext.kakao.ui.NSSplitView;
import io.spotnext.kakao.ui.NSTableCellView;
import io.spotnext.kakao.ui.NSTableColumn;
import io.spotnext.kakao.ui.NSTextField;
import io.spotnext.kakao.ui.NSToolbar;
import io.spotnext.kakao.ui.NSToolbarItem;
import io.spotnext.kakao.ui.NSView;
import io.spotnext.kakao.ui.NSWindow;

public class MainWindow {

	private final NSWindow window;
	private NSOutlineView explorerSidebar;
	private NSView detailsSidebar;
	private NSTextField editorView;

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

		var explorerSidebarScrollView = createExplorerSidebar(sidebarX, sidebarY, sidebarWidth, sidebarHeight);
		var detailsSidebarScrollView = createDetailsSidebar(sidebarX, sidebarY, sidebarWidth, sidebarHeight);

		editorView = createCodeEditor(bounds, sidebarX, sidebarY, sidebarWidth, sidebarHeight);

		splitView.addSubview(explorerSidebarScrollView);
		splitView.addSubview(editorView);
		splitView.addSubview(detailsSidebarScrollView);

		// why can't I pass 200?
//		splitView.setPosition(20d, 0);
		splitView.adjustSubviews();
		splitView.setAutoresizingMask(NSAutoresizingMaskOptions.HeightSizable, NSAutoresizingMaskOptions.WidthSizable);
//		splitView.setHoldingPriorityForSubview(490, 0);

		window.addSubview(splitView);
	}

	private NSTextField createCodeEditor(NSRect bounds, int sidebarX, int sidebarY, double sidebarWidth,
			double sidebarHeight) {
		var textFieldX = sidebarX + sidebarWidth * 2;
		var textFieldY = sidebarY;
		var textFieldWidth = bounds.size.width.doubleValue() - sidebarWidth * 2;
		var textFieldHeight = sidebarHeight;

		var textField = new NSTextField(new NSRect(textFieldX, textFieldY, textFieldWidth, textFieldHeight));
		textField.setFocusRingType(NSFocusRingType.None);
		textField.setBordered(false);
		textField.setFont(new NSFont("Monaco", 12.));

		return textField;
	}

	private NSScrollView createExplorerSidebar(int sidebarX, int sidebarY, double sidebarWidth, double sidebarHeight) {
		explorerSidebar = new NSOutlineView();
		explorerSidebar.setSelectionHighlightStyle(SelectionHighlightStyle.SourceList);

		var col1 = new NSTableColumn("Content");
		col1.setEditable(false);
		col1.getHeaderCell().setStringValue("Content");
		explorerSidebar.setRowSizeStyle(NSTableViewRowSizeStyle.Default);
		explorerSidebar.addTableColumn(col1);
		explorerSidebar.setOutlineTableColumn(col1);
		explorerSidebar.setTableHeaderView(null);
		explorerSidebar.setFloatsGroupRows(false);

		var delegate = new NSOutlineViewDelegate(explorerSidebar) {
			@Override
			@Msg(selector = "outlineView:viewForTableColumn:item:", signature = "@@:@@@")
			public Proxy outlineViewViewForTableColumn(Proxy outlineView, Proxy tableColumn, Proxy item) {
				var proxy = super.outlineViewViewForTableColumn(outlineView, tableColumn, item);

				var iconProxy = item.sendProxy("icon");
				if (iconProxy != null) {
					var view = new NSTableCellView(proxy);
					var imageViewProxy = iconProxy.sendProxy("handler");
					view.getImageView().setImage(new NSImage(imageViewProxy));
				}

				return proxy;
			}
		};

		delegate.onSelectionChanged(item -> {
			if (item instanceof DataLeafNode) {
				var object = (ExplorerNode) item.getObject();
				if (object.isFile()) {
					showFileInEditor(object.getFilePath());
				}
			}
		});

		explorerSidebar.setDelegate(delegate);

		var sidebarRect = new NSRect(sidebarX, sidebarY, sidebarWidth, sidebarHeight);
		var clipView = new NSClipView();
		clipView.setAutoresizesSubviews(true);
		clipView.setDocumentView(explorerSidebar);

		var sidebarScrollView = new NSScrollView(sidebarRect);
		sidebarScrollView.setContentView(clipView);

		return sidebarScrollView;
	}

	private void showFileInEditor(String filePath) {
		String fileValue;
		try {
			fileValue = Files.readString(Paths.get(filePath));
		} catch (IOException e) {
			fileValue = "";
		}

		editorView.setText(fileValue);
	}

	private NSScrollView createDetailsSidebar(int sidebarX, int sidebarY, double sidebarWidth, double sidebarHeight) {
		detailsSidebar = new NSView("NSView", NSRect.DEFAULT);
		var sidebarRect = new NSRect(sidebarX, sidebarY, sidebarWidth, sidebarHeight);
		var clipView = new NSClipView();
		clipView.setAutoresizesSubviews(true);
		clipView.setDocumentView(detailsSidebar);

		var sidebarScrollView = new NSScrollView(sidebarRect);
		sidebarScrollView.setContentView(clipView);

		return sidebarScrollView;
	}

	public NSToolbar createToolbar() {
		var toolbar = new NSToolbar();

		int itemIndex = 0;

		var runButtonItem = new NSToolbarItem("runButtonItem");
		runButtonItem.setLabel("Run");
		runButtonItem.setToolTip("Build and then run the current application");
		var runButton = new NSButton(createImageFromResource("/images/toolbar/run.png"));
		runButton.setFrameSize(NSSize.of(50, 0));
		runButtonItem.setView(runButton);
		toolbar.insertItem(runButtonItem, itemIndex++);

		var stopButtonItem = new NSToolbarItem("stopButtonItem");
		stopButtonItem.setLabel("Stop");
		stopButtonItem.setToolTip("Stop the current application");
		stopButtonItem.setEnabled(false);
		var stopButton = new NSButton(createImageFromResource("/images/toolbar/stop.png"));
		stopButton.setFrameSize(NSSize.of(50, 0));
		stopButtonItem.setView(stopButton);
		stopButton.setEnabled(false);
		toolbar.insertItem(stopButtonItem, itemIndex++);

		var buildButtonItem = new NSToolbarItem("buildButtonItem");
		buildButtonItem.setLabel("Build");
		buildButtonItem.setToolTip("Build the current application");
		var buildButton = new NSButton(createImageFromResource("/images/toolbar/compile.png"));
		buildButton.setFrameSize(NSSize.of(50, 0));
		buildButtonItem.setView(buildButton);
		toolbar.insertItem(buildButtonItem, itemIndex++);

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

		explorerSidebar.setDataSource(new NSOutlineViewDataSource(root) {
		});

	}

	private DataNode createNode(ExplorerNode node) {
		final DataNode dataNode;

		if (node.getNodes().size() > 0) {
			var title = node.getName();

			var dataGroupNode = new DataGroupNode(title);
			dataNode = dataGroupNode;

			for (var subNode : node.getNodes()) {
				dataGroupNode.addNodes(createNode(subNode));
			}

			if (!node.isGroupHeader()) {
				var icon = createImageFromResource("/images/filetypes/folder_closed.png");
				dataNode.setIcon(icon);
			} else {
				dataGroupNode.setExpanded(true);
			}
		} else {
			dataNode = new DataLeafNode(node.getName());
			dataNode.setObject(node);

			if (!node.isGroupHeader()) {
				var icon = createImageFromResource("/images/filetypes/code.png");
				dataNode.setIcon(icon);
			}
		}

		if (node.isGroupHeader()) {
			dataNode.setTitle(dataNode.getTitle().toUpperCase());
		}

		dataNode.setHeader(node.isGroupHeader());

		return dataNode;
	}

	private NSImage createImageFromResource(String resourcePath) {
		var iconData = NSData.dataFromResource(resourcePath);
		var icon = new NSImage(iconData);
		return icon;
	}
}