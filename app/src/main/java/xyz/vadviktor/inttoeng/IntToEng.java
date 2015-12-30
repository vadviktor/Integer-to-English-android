package xyz.vadviktor.inttoeng;


public class IntToEng {

    protected static String[] singles   = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    protected static String[] tens      = new String[]{"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    protected static String[] ten_frags = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    protected static String[] scale     = new String[]{"", "thousand", "million", "billion", "trillion", "quadrillion"};

    public static String convert(String number) {
        return convert(number, false);
    }

    public static String convert(String number, boolean us) {

        // 0
        if (number.length() == 1 && number.equals("0")) {
            return "zero";
        }

        // 1..999
        if (number.length() < 4) {
            return get_hundreds(number, us);
        }

        // 999 <
        int i = 0;


        return null;
    }

    protected static String get_hundreds(String number, boolean us) {
        String two = get_2_decimals(number);
        if (two != null) {
            return two;
        }

        return get_3_decimals(number, us);
    }

    /**
     * @param number String
     * @return String|null
     */
    protected static String get_2_decimals(String number) {
        // 0
        if (number.length() == 1 && number.equals("0")) {
            return "";
        }

        // 1..9 / 01..09
        if ((number.length() == 1 && !number.equals("0")) ||
                (number.length() == 2 &&
                        number.charAt(0) == '0' &&
                        number.charAt(1) != '0')
                ) {
            return singles[Integer.parseInt(number)];
        }

        // tens
        if (number.length() == 2 && number.charAt(1) == '0') {
            return tens[Integer.parseInt(String.valueOf(
                    number.charAt(0)
            ))];
        }

        // 11..19
        if (number.length() == 2 && number.charAt(0) == '1' && number.charAt(1) != '0') {
            return ten_frags[Integer.parseInt(String.valueOf(
                    number.charAt(1)
            ))];
        }

        // 21..99
        if (number.length() == 2 &&
                Integer.parseInt(String.valueOf(number.charAt(0))) > 1 &&
                Integer.parseInt(String.valueOf(number.charAt(1))) >= 1) {
            String _ten = tens[Integer.parseInt(String.valueOf(number.charAt(0)))];
            String _single = singles[Integer.parseInt(String.valueOf(number.charAt(1)))];
            return _ten + "-" + _single;
        }

        return null;
    }

    /**
     * @param number String
     * @param us     boolean
     * @return String|null
     */
    protected static String get_3_decimals(String number, boolean us) {
        if (number.length() == 3 && number.charAt(0) != '0') {
            String final_number = singles[Integer.parseInt(String.valueOf(number.charAt(0)))] + " hundred";

            if (number.charAt(1) != '0' || number.charAt(2) != '0') {
                final_number += (us ? " " : " and ");
                final_number += get_2_decimals(number.substring(1, 3));
            }

            return final_number;
        }

        return null;
    }

}
