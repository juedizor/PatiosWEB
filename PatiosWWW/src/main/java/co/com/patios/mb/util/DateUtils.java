package co.com.patios.mb.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

	private static DateUtils INSTANCE;

	private DateUtils() {
		// TODO Auto-generated constructor stub
	}

	public static DateUtils getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DateUtils();
		}
		return INSTANCE;
	}

	public java.sql.Timestamp getFechaActual() {
		Date date = new Date();
		return new Timestamp(date.getTime());
	}

	public static String formatDate(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format, new Locale("es"));
		return dateFormat.format(date);
	}

	public static Date formatDate(String date, String format) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format, new Locale("es"));
		return dateFormat.parse(date);
	}

}
