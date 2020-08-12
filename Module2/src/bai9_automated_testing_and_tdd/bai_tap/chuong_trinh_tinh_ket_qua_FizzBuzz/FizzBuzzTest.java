package bai9_automated_testing_and_tdd.bai_tap.chuong_trinh_tinh_ket_qua_FizzBuzz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    void testFizzBuzz0() {
        int number = 0;
        String expected = "FizzBuzz";

        String result = FizzBuzz.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz1() {
        int number = 3;
        String expected = "Fizz";

        String result = FizzBuzz.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz2() {
        int number = 5;
        String expected = "Buzz";

        String result = FizzBuzz.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz3() {
        int number = 15;
        String expected = "FizzBuzz";

        String result = FizzBuzz.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz4() {
        int number = 1;
        String expected =" MỘT" ;

        String result = FizzBuzz.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz5() {
        int number = 53;
        String expected ="BuzzFizz NĂM MƯƠI BA" ;

        String result = FizzBuzz.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz6() {
        int number = 35;
        String expected ="Buzz" ;

        String result = FizzBuzz.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz7() {
        int number = 98;
        String expected =" CHÍN MƯƠI TÁM" ;

        String result = FizzBuzz.translate(number);
        assertEquals(expected, result);
    }
}
