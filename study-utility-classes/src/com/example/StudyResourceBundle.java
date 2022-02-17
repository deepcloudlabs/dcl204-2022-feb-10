package com.example;

import java.text.MessageFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

@SuppressWarnings("unused")
public class StudyResourceBundle {

	public static void main(String[] args) {
		var turkish = new Locale("tr", "TR");
		var activeLocale = Locale.US;
		ResourceBundle bundle = ResourceBundle.getBundle("messages",activeLocale);
		var message = bundle.getString("label.generate.time");
		var now = ZonedDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(activeLocale);
        MessageFormat formatter = new MessageFormat(message,activeLocale);
		System.out.println(formatter.format(new Object[] {dtf.format(now)}));
		// Spring MVC, JSF -> JDK's i18n
	}

}
