package cn.com.transcosmos.training.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DateUtil {

	public static String getCurrentDateInString(String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(Calendar.getInstance().getTime());
	}
}
