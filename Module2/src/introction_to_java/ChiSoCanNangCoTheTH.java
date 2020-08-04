package introction_to_java;

import java.util.Scanner;

public class ChiSoCanNangCoTheTH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Cân Nặng (Kg): ");
        double canNang = scanner.nextDouble();
        System.out.println("Nhập Chiều Cao (Meter): ");
        double chieuCao = scanner.nextDouble();
        double chiSoBMI = canNang / (chieuCao * chieuCao);
        System.out.println("BMI: " + chiSoBMI);
        if (chiSoBMI < 18.5) {
            System.out.println("Bạn Quá Gầy");
        } else if (chiSoBMI < 25.0) {
            System.out.println("Bạn Bình Thường");
        } else if (chiSoBMI < 30.0) {
            System.out.println("Bạn Bị Thừa Cân");
        } else {
            System.out.println("Bạn Bị Béo Phì");
        }
    }
}
