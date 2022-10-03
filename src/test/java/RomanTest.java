import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanTest {
    Roman roman;

    @BeforeEach
    void setup() {
        this.roman = new Roman();
    }

    @Test
    void throwException_forUnsupportedValues() {
        assertThrows(IllegalArgumentException.class, () -> this.roman.convert(0));
        assertThrows(IllegalArgumentException.class, () -> this.roman.convert(3001));
    }

    @ParameterizedTest
    @CsvSource({"I,1", "II,2", "III,3"})
    void returnIs_whenOnes(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({"V,5", "VI,6", "VII,7", "VIII,8"})
    void returnVs_forFives(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({"IV,4", "IX,9"})
    void return_forSpecialLessThan10(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({"X,10", "XI,11", "XII,12", "XIII,13"})
    void returnXs_forTens(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({"XIV,14", "XV,15", "XIX,19"})
    void return_forSpecialLessThan20(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({"XL,40", "XLIV,44"})
    void return_forSpecialLessThan50(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({
            "L,50", "LI,51", "LII,52",
            "LX,60", "LXX,70", "LXXX,80"
    })
    void returnLs_forFifties(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({"XC,90", "XCIV,94"})
    void return_forSpecialLessThan100(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({
            "C,100", "CI,101", "CXI,111", "CC,200", "CCC,300"
    })
    void returnCs_forHundreds(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({
            "CD,400", "CDXLIV,444"
    })
    void return_forSpecialLessThan500(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({
            "D,500", "DC,600", "DCC,700", "DCCC,800"
    })
    void returnDs_forFiveHundreds(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({
            "CM,900", "CMXCIX,999"
    })
    void return_forSpecialLessThan1000(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    @ParameterizedTest
    @CsvSource({
            "M,1000", "MM,2000", "MMM,3000", "MMDCCLI,2751", "MMCMXCIX,2999"
    })
    void returnMs_forThousands(String expected, int number) {
        assertEquals(expected, this.roman.convert(number));
    }

    // Vice Versa

    @ParameterizedTest
    @CsvSource(value = {"1,I", "2,II", "3,III"})
    void return_forIs(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"4,IV", "9,IX"})
    void return_forSpecialIs(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"5,V", "6,VI", "7,VII", "8,VIII"})
    void return5_forV(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"10,X", "11,XI", "12,XII", "13,XIII"})
    void return10_forX(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"40,XL", "44,XLIV"})
    void return_forSpecialXs(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"50,L", "51,LI", "52,LII", "53,LIII"})
    void return50_forL(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"90,XC", "94,XCIV"})
    void return_forSpecialXCs(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"100,C", "101,CI", "102,CII", "103,CIII"})
    void return100_forC(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"400,CD", "444,CDXLIV"})
    void return_forSpecialCDs(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"500,D", "501,DI", "502,DII", "503,DIII"})
    void return500_forD(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"900,CM", "999,CMXCIX"})
    void return_forSpecialCMs(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,M", "1001,MI", "1002,MII", "1003,MIII", "2751,MMDCCLI", "2999,MMCMXCIX", "3000,MMM"})
    void return1000_forM(int expected, String numeral) {
        assertEquals(expected, this.roman.convert(numeral));
    }

    @Test
    void throwException_forUnsupportedOrInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> this.roman.convert(null));
        assertThrows(IllegalArgumentException.class, () -> this.roman.convert(""));
        assertThrows(IllegalArgumentException.class, () -> this.roman.convert("MMMI"));
    }

}
