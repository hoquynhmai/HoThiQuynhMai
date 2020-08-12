package bai9_automated_testing_and_tdd.bai_tap.phan_loai_tam_giac;

public class Triangle {
    int side1;
    int side2;
    int side3;

    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public int getSide3() {
        return side3;
    }

    public void setSide3(int side3) {
        this.side3 = side3;
    }

    public static String testTriangle(int side1, int side2, int side3) {
        String result = " ";
        if (conditionTriangle(side1, side2, side3).equals("Tam giác thường")) {
            result = "Tam giác thường";
            if ((side1 == side2) || (side2 == side3) || (side3 == side1)) {
                result = "Tam giác cân";
            }
            if (side1 == side2 && side2 == side3) {
                result = "Tam giác đều";
            }
        } else return "Không phải tam giác";
        return result;
    }

    // Điều kiện hình thành 1 tam giác
    public static String conditionTriangle(int side1, int side2, int side3) {
        if ((side1 + side2 > side3) && (side1 + side3) > side2 && (side3 + side2) > side1) {
            return "Tam giác thường";
        } else {
            return "Không phải tam giác";
        }
    }
}



//
//    //Tam giác cân
//    public static String isoscelesTriangle(int side1, int side2, int side3) {
//        if (conditionTriangle(side1,side2,side3).equals("Tam giác thường")) {
//            if ((side1 == side2) || (side2 == side3) || (side3 == side1)) {
//                return "Tam giác cân";
//            } else {
//                return "Tam giác thường";
//            }
//        }
//        return " ";
//    }
//
//    //Tam giác đều
//    public static String equilateralTriangle(int side1, int side2, int side3) {
//        if (conditionTriangle(side1,side2,side3).equals("Tam giác thường")) {
//            if (side1 == side2 && side2 == side3) {
//                return "Tam giác đều";
//            }
//        }
//        return " ";
//    }
//}