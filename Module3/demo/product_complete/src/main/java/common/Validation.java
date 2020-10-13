package common;

public class Validation {
    public static boolean regexPositiveIntegers(String number) {
        return !number.matches("\\d+") || Integer.parseInt(number) < 0;
    }

    public static boolean regexPositiveNumbers(String number) {
        return !number.matches("\\d+([.]\\d+)?") || !(Float.parseFloat(number) >= 0);
    }
}
