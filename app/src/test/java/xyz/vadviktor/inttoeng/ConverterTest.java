package xyz.vadviktor.inttoeng;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static xyz.vadviktor.inttoeng.IntToEng.convert;

public class ConverterTest {

    @Test
    public void convert_0_to_9() {
        assertEquals("zero", convert("0"));
        assertEquals("one", convert("1"));
        assertEquals("two", convert("2"));
        assertEquals("three", convert("3"));
        assertEquals("four", convert("4"));
        assertEquals("five", convert("5"));
        assertEquals("six", convert("6"));
        assertEquals("seven", convert("7"));
        assertEquals("eight", convert("8"));
        assertEquals("nine", convert("9"));
    }

    @Test
    public void convert_10s() {
        assertEquals("ten", convert("10"));
        assertEquals("twenty", convert("20"));
        assertEquals("thirty", convert("30"));
        assertEquals("forty", convert("40"));
        assertEquals("fifty", convert("50"));
        assertEquals("sixty", convert("60"));
        assertEquals("seventy", convert("70"));
        assertEquals("eighty", convert("80"));
        assertEquals("ninety", convert("90"));
    }

    @Test
    public void convert_11_to_19() {
        assertEquals("eleven", convert("11"));
        assertEquals("twelve", convert("12"));
        assertEquals("thirteen", convert("13"));
        assertEquals("fourteen", convert("14"));
        assertEquals("fifteen", convert("15"));
        assertEquals("sixteen", convert("16"));
        assertEquals("seventeen", convert("17"));
        assertEquals("eighteen", convert("18"));
        assertEquals("nineteen", convert("19"));
    }

    @Test
    public void convert_21_to_99() {
        assertEquals("twenty-one", convert("21"));
        assertEquals("forty-two", convert("42"));
        assertEquals("sixty-five", convert("65"));
        assertEquals("ninety-nine", convert("99"));
    }

    @Test
    public void convert_100s() {
        assertEquals("one hundred", convert("100"));
        assertEquals("two hundred", convert("200"));
        assertEquals("nine hundred", convert("900"));

        assertEquals("one hundred and one", convert("101"));
        assertEquals("one hundred and ten", convert("110"));
        assertEquals("one hundred and eleven", convert("111"));
    }

    @Test
    public void convert_hundreds_in_usa() {
        assertEquals("two hundred seventy-three", convert("273", true));
        assertEquals("five hundred six", convert("506", true));
        assertEquals("four hundred fifty-three", convert("453", true));
    }

    @Test
    public void convert_hundreds_in_british() {
        assertEquals("two hundred and seventy-three", convert("273"));
        assertEquals("five hundred and six", convert("506"));
    }

    @Test
    public void convert_1000s() {
        assertEquals("one thousand", convert("1000"));
        assertEquals("two thousand", convert("2000"));
        assertEquals("nine thousand", convert("9000"));

        assertEquals("one thousand one", convert("1001"));
        assertEquals("one thousand one hundred", convert("1100"));
        assertEquals("one thousand eleven", convert("1011"));
        assertEquals("one thousand one hundred and eleven", convert("1111"));
    }

    @Test
    public void convert_millions() {
        assertEquals("one million", convert("1000000"));
        assertEquals("two million", convert("2000000"));
        assertEquals("nine million", convert("9000000"));
    }

    @Test
    public void convert_billions() {
        assertEquals("one billion", convert("1000000000"));
        assertEquals("two billion", convert("2000000000"));
        assertEquals("nine billion", convert("9000000000"));
    }

    @Test
    public void convert_trillions() {
        assertEquals("one trillion", convert("1000000000000"));
        assertEquals("two trillion", convert("2000000000000"));
        assertEquals("nine trillion", convert("9000000000000"));
    }

    @Test
    public void convert_quadrillions() {
        assertEquals("one quadrillion", convert("1000000000000000"));
        assertEquals("two quadrillion", convert("2000000000000000"));
        assertEquals("nine quadrillion", convert("9000000000000000"));
    }

    @Test
    public void convert_any_numbers_it_could() {
        assertEquals("forty-three thousand four hundred and two", convert("43402"));
        assertEquals("three hundred thirty thousand four hundred two", convert("330402", true));
        assertEquals(
                "six hundred twenty-three quadrillion seven hundred seventy-seven trillion four million three thousand four hundred two",
                convert("623777000004003402", true)
        );
        assertEquals(
                "six hundred and twenty-three quadrillion seven hundred and seventy-seven trillion four million three thousand four hundred and two",
                convert("623777000004003402")
        );
    }

}