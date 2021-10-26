package com.app.stock.util;

/**
 * Created by Rozita on 10/21/21.
 */
public class StringUtil {

    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String ZERO = "0";

    /**
     * Checks if is empty.
     *
     * @param str the str
     * @return true, if is empty
     */
    public static boolean isEmpty(String str) {
        return (str == null) || str.trim().equals(EMPTY);
    }

    /**
     * Checks for text.
     *
     * @param str the str
     * @return true, if successful
     */
    public static boolean hasText(String str) {
        return !isEmpty(str);
    }

    /**
     * Removes the redundant characters.
     *
     * @param srcStr  the src str
     * @param pattern the pattern
     * @return the string
     */
    public static String removeRedundantCharacters(String srcStr, String pattern) {
        if (isEmpty(srcStr) || isEmpty(pattern)) {
            return srcStr;
        }

        String destStr = srcStr;

        while ((destStr.length() >= pattern.length()) &&
                destStr.substring(0, pattern.length()).equals(pattern)) {
            destStr = destStr.substring(pattern.length());
        }

        return destStr;
    }
}
