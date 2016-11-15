package lk.health.phd.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Utility class.
 * 
 * @author admin
 *
 */
public class Util {
	/**
	 * 
	 * @param date
	 *            Date in String format.
	 * @param format
	 *            Formatter to format the date.
	 * @return Date
	 * @throws ParseException
	 *             Throws parseException
	 */
	public static Date parseDate(final String inDate, final String inFormat) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(inFormat);

		return new Date(formatter.parse(inDate).getTime());
	}

	public static Date getSystemTime() {
		Date systemDate = new Date(System.currentTimeMillis());

		return systemDate;
	}
}
