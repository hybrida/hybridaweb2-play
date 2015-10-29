package util;

import java.util.Calendar;

public class DateUtil {

    private static final String[] MONTH_NAMES_NORWEGIAN = new String[]{
            "januar",
            "februar",
            "mars",
            "april",
            "mai",
            "juni",
            "juli",
            "august",
            "september",
            "oktober",
            "november",
            "desember"
    };

	public static String calendarToString(Calendar convert) {
		Integer year = convert.get(Calendar.YEAR),
			month = convert.get(Calendar.MONTH) + 1,
			day = convert.get(Calendar.DAY_OF_MONTH),
			hour = convert.get(Calendar.HOUR_OF_DAY),
			mins = convert.get(Calendar.MINUTE);
		return "" + year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day) + "T" + String.format("%02d", hour) + ":" + String.format("%02d", mins);
	}

    public static String calendarToColloquial(Calendar time) {
        Calendar now = Calendar.getInstance();
        Calendar recently = Calendar.getInstance();
        recently.add(Calendar.MONTH, -2);
        Calendar soon = Calendar.getInstance();
        soon.add(Calendar.MONTH, 5);
        if(time.after(soon) || time.before(recently)) {
            return "" + time.get(Calendar.DAY_OF_MONTH) + ". " + MONTH_NAMES_NORWEGIAN[time.get(Calendar.MONTH)].substring(0, 3) + ". '" + (time.get(Calendar.YEAR) % 100);
        }
        recently = Calendar.getInstance();
        recently.add(Calendar.DATE, -5);
        soon = Calendar.getInstance();
        soon.add(Calendar.DATE, 9);
        if(time.after(soon) || time.before(recently)) {
            return "" + time.get(Calendar.DAY_OF_MONTH) + ". " + MONTH_NAMES_NORWEGIAN[time.get(Calendar.MONTH)];
        }
        if(time.before(now)) {
            long diff = now.getTimeInMillis() - time.getTimeInMillis();
            Calendar calDiff = Calendar.getInstance();
            calDiff.setTimeInMillis(diff);
            return "For " + calDiff.get(Calendar.DAY_OF_YEAR) + " dager siden";
        }
        soon = Calendar.getInstance();
        soon.add(Calendar.HOUR, 8);
        if(time.before(soon)) {
            long diff = time.getTimeInMillis() - now.getTimeInMillis();
            Calendar calDiff = Calendar.getInstance();
            calDiff.setTimeInMillis(diff);
            return "Om " + calDiff.get(Calendar.HOUR_OF_DAY) + " timer";
        }
        long diff = time.getTimeInMillis() - now.getTimeInMillis();
        Calendar calDiff = Calendar.getInstance();
        calDiff.setTimeInMillis(diff);
        return "Om " + calDiff.get(Calendar.DAY_OF_YEAR) + " dager";
    }
}
