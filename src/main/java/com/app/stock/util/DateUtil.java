package com.app.stock.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rozita on 10/21/21.
 */
public class DateUtil {

    /**
     * The Constant STOCK_DATE_PATTERN.
     */
    public static final String STOCK_DATE_PATTERN = "MM/dd/yyyy";

    private static Map formatHolder = new HashMap();

    /**
     * Instantiates a new date util.
     */
    public DateUtil() {
    }

    /**
     * Convert string to date.
     *
     * @param pattern the pattern
     * @param strDate the string date
     * @return the date
     * @throws ParseException the parse exception
     */
    public synchronized static final Date convertStringToDate(String pattern, String strDate)
            throws ParseException {
        Date date;
        SimpleDateFormat df = getSimpleDateFormat(pattern);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }
        return date;
    }

    public synchronized static String convertDateToString(String pattern, Date date) {
        return getSimpleDateFormat(pattern).format(date);
    }

    private static SimpleDateFormat getSimpleDateFormat(String pattern) {
        return (SimpleDateFormat) getFormat(pattern);
    }

    private static Object getFormat(String pattern) {
        if (formatHolder.get(pattern) == null) {
            formatHolder.put(pattern, new SimpleDateFormat(pattern));
        }
        return formatHolder.get(pattern);
    }
}
