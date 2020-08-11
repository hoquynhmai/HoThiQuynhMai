package bai9_automated_testing_and_tdd.bai_tap.chuong_trinh_tinh_ket_qua_FizzBuzz;

public class FizzBuzz {
    public static String fizzBuzz (int number){
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz){
            return "FizzBuzz";
        } else if (isFizz){
            return "Fizz";
        } else if (isBuzz){
            return "Buzz";
        }
        return number + " ";
    }
}
