package xyz.vadviktor.inttoeng;


public class IntToEng {

    protected static String[] singles   = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    protected static String[] tens      = new String[]{"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    protected static String[] ten_frags = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    protected static String[] scale     = new String[]{"", "thousand", "million", "billion", "trillion", "quadrillion"};

    public static String convert(String i) {
        return convert(i, false);
    }

    public static String convert(String i, boolean us) {

        // 0
        if (i.length() == 1 && i.equals("0")) {
            return "zero";
        }

        // 1..999
        if (i.length() < 4) {
            return get_hundreds(i, us);
        }

        // 999 <

        // ...

        return null;
    }

    protected static String get_hundreds(String i, boolean us) {
        String two = get_2_decimals(i);
        if (two != null) {
            return two;
        }

        return get_3_decimals(i, us);
    }

    /**
     * @param i String
     * @return String|null
     */
    protected static String get_2_decimals(String i) {
        // 0
        if (i.length() == 1 && i.equals("0")) {
            return "";
        }

        // 1..9
        if (i.length() == 1 && !i.equals("0")) {
            return singles[Integer.parseInt(i)];
        }

        // tens
        if (i.length() == 2 && i.charAt(1) == '0') {
            return tens[Integer.parseInt(String.valueOf(
                    i.charAt(0)
            ))];
        }

        // 11..19
        if (i.length() == 2 && i.charAt(0) == '1' && i.charAt(1) != '0') {
            return ten_frags[Integer.parseInt(String.valueOf(
                    i.charAt(1)
            ))];
        }

        // 21..99
        if (i.length() == 2 && i.charAt(0) != '1' && i.charAt(1) != '0') {
            String _ten = tens[Integer.parseInt(String.valueOf(i.charAt(0)))];
            String _single = singles[Integer.parseInt(String.valueOf(i.charAt(1)))];
            return _ten + "-" + _single;
        }

        return null;
    }

    /**
     * @param i  String
     * @param us boolean
     * @return String|null
     */
    protected static String get_3_decimals(String i, boolean us) {
        if (i.length() == 3 && i.charAt(0) != '0') {
            String final_number = singles[Integer.parseInt(String.valueOf(i.charAt(0)))] + " hundred";

            if (i.charAt(1) != '0' || i.charAt(2) != '0') {
                final_number += (us ? " " : " and ");
                final_number += get_2_decimals(i.substring(1,2));
            }

            return final_number;
        }

        return null;
    }

}
