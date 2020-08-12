package bai9_automated_testing_and_tdd.bai_tap.chuong_trinh_tinh_ket_qua_FizzBuzz;

public class FizzBuzz {
    public static String translate(int number) {
        if (number >= 0 && number < 100) {
            if (fizzBuzz(number).equals("")) {
                String result = "";
                if (fizzBuzzContains3and5(number).equals("")) {
                    result += readNumber(number);
                } else {
                    result = fizzBuzzContains3and5(number);
                    result += readNumber(number);
                }
                return result;
            } else return fizzBuzz(number);
        } else return "Invalid Number !";
    }

    //Số chia hết cho 3, 5
    public static String fizzBuzz(int number) {
        String result = "";
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz) {
            result += "FizzBuzz";
        } else if (isFizz) {
            result += "Fizz";
        } else if (isBuzz) {
            result += "Buzz";
        }
        return result;
    }

    // Số không chia hết cho 3,5 nhưng chứa 3, 5
    public static String fizzBuzzContains3and5(int number) {
        String result = "";
        int dozenRow = number / 10;
        int unitRow = number - (dozenRow * 10);
         if ((dozenRow == 5) || (unitRow == 5)) {
            result += "Buzz";
        }
        if ((dozenRow == 3) || (unitRow == 3)) {
            result += "Fizz";
        }
        return result;
    }

    // Đọc số
    public static String readNumber(int number) {
        String result = "";
        int unitRow;
        int dozenRow = 0;
        if (number < 10) {
            unitRow = number;
        } else {
            dozenRow = number / 10;
            unitRow = number - (dozenRow * 10);
        }

        switch (dozenRow) {
            case 1:
                result += "MƯỜI";
                break;
            case 2:
                result += " HAI MƯƠI";
                break;
            case 3:
                result += " BA MƯƠI";
                break;
            case 4:
                result += " BÓN MƯƠI";
                break;
            case 5:
                result += " NĂM MƯƠI";
                break;
            case 6:
                result += " SÁU MƯƠI";
                break;
            case 7:
                result += " BẢY MƯƠI";
                break;
            case 8:
                result += " TÁM MƯƠI";
                break;
            case 9:
                result += " CHÍN MƯƠI";
                break;
        }

        switch (unitRow) {
            case 0:
                result += "KHÔNG";
                break;
            case 1:
                if (dozenRow > 1) {
                    result += " MỐT";
                } else {
                    result += " MỘT";
                }
                break;
            case 2:
                result += " HAI";
                break;
            case 3:
                result += " BA";
                break;
            case 4:
                result += " BÓN";
                break;
            case 5:
                if (dozenRow > 1) {
                    result += " LĂM";
                } else {
                    result += " NĂM";
                }
                break;
            case 6:
                result += " SÁU";
                break;
            case 7:
                result += " BẢY";
                break;
            case 8:
                result += " TÁM";
                break;
            case 9:
                result += " CHÍN";
                break;
        }
        return result;
    }
}
