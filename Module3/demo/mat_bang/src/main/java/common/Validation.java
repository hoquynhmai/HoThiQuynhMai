package common;

public class Validation {
    public static boolean regexID(String id) {
        return !id.matches("^(LA-)(\\d{3})$");
    }

    // Là số thực lớn hơn 0
    public static boolean regexAreaAndPrice(String number) {
        return !number.matches("\\d+([.]\\d+)?") || !(Double.parseDouble(number) >= 0);
    }

    // Là số nguyên dương
    public static boolean regexPositiveIntegers(String number) {
        return !number.matches("\\d+") || Integer.parseInt(number) < 0;
    }

//    public static boolean regexAge(String age) {
//        return !age.matches("\\d+") || Integer.parseInt(age) < 18;
//    }
//
//    public static boolean regexEmail(String email) {
//        return !email.matches("^\\w{3,}@[a-z]{3,7}\\.[a-z]{2,3}$");
//    }
//
//    public static boolean regexPhoneNumber(String phoneNumber) {
//        return !phoneNumber.matches("^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$");
//    }
}
