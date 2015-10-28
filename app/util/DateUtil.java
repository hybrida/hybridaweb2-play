package util;

import java.util.Calendar;

public class DateUtil {
	public static String calendarToString(Calendar convert) {
		Integer year = convert.get(Calendar.YEAR),
			month = convert.get(Calendar.MONTH) + 1,
			day = convert.get(Calendar.DAY_OF_MONTH),
			hour = convert.get(Calendar.HOUR_OF_DAY),
			mins = convert.get(Calendar.MINUTE);
		return "" + year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day) + "T" + String.format("%02d", hour) + ":" + String.format("%02d", mins);
	}
}
