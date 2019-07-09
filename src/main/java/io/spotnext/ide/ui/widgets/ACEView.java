package io.spotnext.ide.ui.widgets;

import io.spotnext.kakao.NSObject;
import io.spotnext.kakao.foundation.NSRect;
import io.spotnext.kakao.ui.NSScrollView;

public class ACEView extends NSScrollView {
	public ACEView(NSRect frame) {
		super("ACEView", frame);
//		initWebView();
		setDelegate(this);
	}

	private void setDelegate(NSObject delegate) {
		getNativeHandle().send("setDelegate:", delegate);
	}

	protected void initWebView() {
		getNativeHandle().send("initWebView");
	}

	public void setText(String string) {
		getNativeHandle().send("setString:", string);
	}

	public void setPrintMarginColumn(int column) {
		getNativeHandle().send("setPrintMarginColumn:", column);
	}
}
