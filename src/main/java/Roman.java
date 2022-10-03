import java.util.LinkedHashMap;
import java.util.Map;

public class Roman {

    private final Map<Integer, String> map = new LinkedHashMap<>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    public String convert(int number) {
        if (number <= 0 || number > 3000) {
            throw new IllegalArgumentException("Numbers from 1 to 3000 are supported");
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            while (number >= entry.getKey()) {
                sb.append(entry.getValue());
                number -= entry.getKey();
            }
        }
        return sb.toString();
    }

    public int convert(String numeral) {
        if (numeral == null || numeral.trim().equals("")) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (numeral.length() > 3 && numeral.startsWith("MMM")) {
            throw new IllegalArgumentException("Numeral from I to MMM are supported");
        }
        // TODO: Validation for more than 5000
        int result = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            while (numeral.startsWith(entry.getValue())) {
                result += entry.getKey();
                numeral = numeral.substring(entry.getValue().length());
            }
        }
        result += numeral.length();
        return result;
    }
}
