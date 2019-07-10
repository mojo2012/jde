package io.spotnext.ide.ui.widgets;

import io.spotnext.ide.structs.ACEMode;
import io.spotnext.ide.structs.ACETheme;
import io.spotnext.kakao.NSObject;
import io.spotnext.kakao.foundation.NSRect;
import io.spotnext.kakao.structs.NSBorderType;
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

	public void setShowInvisibleCharacters(boolean value) {
		getNativeHandle().send("setShowInvisibles:", value);
	}

	public void setTheme(ACETheme theme) {
		getNativeHandle().send("setTheme:", theme.id);
	}

	public void setMode(ACEMode mode) {
		getNativeHandle().send("setMode:", mode.id);
	}

	public void setFont(String fontFamily, int size) {
		getNativeHandle().send("setFontFamily:", fontFamily);
		getNativeHandle().send("setFontSize:", size);
	}

	public void setShowLineNumbers(boolean value) {
		getNativeHandle().send("setShowLineNumbers:", value);
	}

	public void setShowGutter(boolean value) {
		getNativeHandle().send("setShowGutter:", value);
	}

	public void setLiveAutocompletion(boolean value) {
		getNativeHandle().send("setLiveAutocompletion:", value);
	}

	public void setBasicAutoCompletion(boolean value) {
		getNativeHandle().send("setBasicAutoCompletion:", value);
	}

	public void setReadOnly(boolean value) {
		getNativeHandle().send("setReadOnly:", value);
	}

	public void setTabSize(int value) {
		getNativeHandle().send("setTabSize:", value);
	}

	public void setUseSoftTabs(boolean value) {
		getNativeHandle().send("setUseSoftTabs:", value);
	}

	public void focus() {
		getNativeHandle().send("focus");
	}

	public void setBorderType(NSBorderType value) {
		getNativeHandle().send("setBorderType:", value.id);
	}

	public void setWrappingBehavioursEnabled(boolean value) {
		getNativeHandle().send("setWrappingBehavioursEnabled:", value);
	}

	public void setUseSoftWrap(boolean value) {
		getNativeHandle().send("setUseSoftWrap:", value);
	}
	
	
}
