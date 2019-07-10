package io.spotnext.ide.structs;

public enum ACEMode {
	ACEModeASCIIDoc(0),
	ACEModeC9Search(1),
	ACEModeCPP(2),
	ACEModeClojure(3),
	ACEModeCoffee(4),
	ACEModeColdfusion(5),
	ACEModeCSharp(6),
	ACEModeCSS(7),
	ACEModeDiff(8),
	ACEModeGLSL(9),
	ACEModeGolang(10),
	ACEModeGroovy(11),
	ACEModeHaxe(12),
	ACEModeHTML(13),
	ACEModeJade(14),
	ACEModeJava(15),
	ACEModeJavaScript(16),
	ACEModeJSON(17),
	ACEModeJSP(18),
	ACEModeJSX(19),
	ACEModeLatex(20),
	ACEModeLESS(21),
	ACEModeLiquid(22),
	ACEModeLua(23),
	ACEModeLuapage(24),
	ACEModeMarkdown(25),
	ACEModeOCaml(26),
	ACEModePerl(27),
	ACEModePGSQL(28),
	ACEModePHP(29),
	ACEModePowershell(30),
	ACEModePython(31),
	ACEModeObjC(32),
	ACEModeRuby(33),
	ACEModeSCAD(34),
	ACEModeScala(35),
	ACEModeSCSS(36),
	ACEModeSH(37),
	ACEModeSQL(38),
	ACEModeSVG(39),
	ACEModeTcl(40),
	ACEModeText(41),
	ACEModeTextile(42),
	ACEModeTypescript(43),
	ACEModeXML(44),
	ACEModeXQuery(45),
	ACEModeYAM(46);

	public final long id;

	private ACEMode(long id) {
		this.id = id;
	}
}
