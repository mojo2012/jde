package io.spotnext.ide.structs;

public enum ACETheme {
	ACEThemeAmbiance(0),
	ACEThemeChrome(1),
	ACEThemeClouds(2),
	ACEThemeCloudsMidnight(3),
	ACEThemeCobalt(4),
	ACEThemeCrimsonEditor(5),
	ACEThemeDawn(6),
	ACEThemeDreamweaver(7),
	ACEThemeEclipse(8),
	ACEThemeGithub(9),
	ACEThemeIdleFingers(10),
	ACEThemeMerbivore(11),
	ACEThemeMerbivoreSoft(12),
	ACEThemeMonoIndustrial(13),
	ACEThemeMonokai(14),
	ACEThemePastelOnDark(15),
	ACEThemeSolarizedDark(16),
	ACEThemeSolarizedLight(17),
	ACEThemeTextmate(18),
	ACEThemeTomorrow(19),
	ACEThemeTomorrowNight(20),
	ACEThemeTomorrowNightBlue(21),
	ACEThemeTomorrowNightBright(22),
	ACEThemeTomorrowNightEighties(23),
	ACEThemeTwilight(24),
	ACEThemeVibrantInk(25),
	ACEThemeXcode(26);

	public final long id;

	private ACETheme(long id) {
		this.id = id;
	}
}
