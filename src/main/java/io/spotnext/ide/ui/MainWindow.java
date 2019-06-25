package io.spotnext.ide.ui;

public class MainWindow  {
//
//	private MainView mainView;
//	private ToolbarItem save, edit, delete;
//
//	public MainWindow() {
//		super();
//	}
//
//	public MainWindow(String windowTitle) {
//		this();
//		setTitle(windowTitle);
//	}
//
//	@Override
//	public void onInit() {
//		mainView = new MainView(this);
//
//		// create tray icon
//		new Tray(this).image(Images.trayIcon).click(this);
//
//		// create toolbar
//		Toolbar tb = new Toolbar(this);
//
//		save = new ToolbarItem(tb).image(Images.TOOLBAR_SAVE).text("Save").click(this);
//		edit = new ToolbarItem(tb).image(Images.TOOLBAR_EDIT).text("Edit").click(this);
//		delete = new ToolbarItem(tb).image(Images.TOOLBAR_DELETE).text("Delete").click(this);
//		new ToolbarItem(tb, Type.SEPARATOR);
//		
//		var statusItemDBName = new StatusLineContributionItem(
//		        "id1", 36);
//		var statusItemDBSize = new StatusLineContributionItem(
//		        "id2", 25);
//		
//		var statusLineManager = new StatusLineManager();
//		statusLineManager.createControl(this.ctrl());
//		statusLineManager.prependToGroup(StatusLineManager.BEGIN_GROUP,
//		        statusItemDBName);
//		statusLineManager.insertAfter("id1",
//		        statusItemDBSize);
//	}
//
//	@OnClick
//	public void onClick(OnClickEvent e) {
//		System.out.println("clicked control = " + e.source());
//	}
//
//	@Override
//	public void onExit() {
//		System.exit(0);
//	}
}