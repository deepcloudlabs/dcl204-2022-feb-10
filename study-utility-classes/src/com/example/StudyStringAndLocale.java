package com.example;

import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@SuppressWarnings("unused")
public class StudyStringAndLocale {

	public static void main(String[] args) {
		var lang = System.getProperty("user.language");
		var country = System.getProperty("user.country");
		System.out.println("language: "+lang);
		System.out.println("country: "+country);
		// String:
		// 1) immutable class
		// 2) object pooling: String name = "jack";
		var city = "izmir";
		System.out.println(city);
		Locale tur = new Locale("tr", "TR");
		var upperCaseCity = city.toUpperCase(Locale.FRANCE);
		System.out.println(city);
		System.out.println(upperCaseCity);
		// i18n: internationalization
		var now = ZonedDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.ITALIAN);
		System.out.println(dtf.format(now));
		// 
		double money = 12_456.7883;
		// user.language, user.country
		DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.ITALY);
		System.out.println(df.format(money));
	}

}
