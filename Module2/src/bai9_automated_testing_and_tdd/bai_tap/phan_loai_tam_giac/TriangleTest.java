package bai9_automated_testing_and_tdd.bai_tap.phan_loai_tam_giac;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    void testTriangle0() {
        int side1 = 3;
        int side2 = 4;
        int side3 = 5;
        String expected = "Tam giác thường";

        String result = Triangle.testTriangle(side1,side2,side3);
        assertEquals(expected, result);
    }

    @Test
    void testTriangle1() {
        int side1 = 8;
        int side2 = 2;
        int side3 = 3;
        String expected = "Không phải tam giác";

        String result = Triangle.testTriangle(side1,side2,side3);
        assertEquals(expected, result);
    }

    @Test
    void testTriangle2() {
        int side1 = -1;
        int side2 = 2;
        int side3 = 1;
        String expected = "Không phải tam giác";

        String result = Triangle.testTriangle(side1,side2,side3);
        assertEquals(expected, result);
    }

    @Test
    void testTriangle3() {
        int side1 = 0;
        int side2 = 1;
        int side3 = 1;
        String expected = "Không phải tam giác";

        String result = Triangle.testTriangle(side1,side2,side3);
        assertEquals(expected, result);
    }

    @Test
    void testTriangle4() {
        int side1 = 2;
        int side2 = 2;
        int side3 = 2;
        String expected = "Tam giác đều";

        String result = Triangle.testTriangle(side1,side2,side3);
        assertEquals(expected, result);
    }

    @Test
    void testTriangle5() {
        int side1 = 2;
        int side2 = 2;
        int side3 = 3;
        String expected = "Tam giác cân";

        String result = Triangle.testTriangle(side1,side2,side3);
        assertEquals(expected, result);
    }
}
