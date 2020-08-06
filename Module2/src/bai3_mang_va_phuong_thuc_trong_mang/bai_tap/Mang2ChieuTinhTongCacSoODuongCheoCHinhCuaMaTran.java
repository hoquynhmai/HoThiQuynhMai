package bai3_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class Mang2ChieuTinhTongCacSoODuongCheoCHinhCuaMaTran {
    public static void main(String[] args) {
        // Nhập ma trận
        int colum, row;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập số cột của ma trận : ");
            colum = scanner.nextInt();
            if (colum > 0) {
                break;
            } else System.out.print("Số cột của bạn không hợp lí ! ");
        } while (true);
        do {
            System.out.print("Nhập số dòng của ma trận : ");
            row = scanner.nextInt();
            if (row > 0) {
                break;
            } else System.out.print("Số dòng của bạn không hợp lí ! ");
        } while (true);

        double[][] matrix = new double[colum][row];
        for (int i = 0; i < colum; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print("matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Các phần tử của ma trận là : ");
        for (int i = 0; i < colum; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        int sum = 0;
        for (int j = 0; j < matrix.length; j++) {
            sum += matrix[j][j];
        }
        System.out.println("Tổng đường chéo của ma trận: " + sum);

        int sum2 = 0;
        for (int i = (matrix.length - 1), j = 0 ; i >= 0 ; i--,j++) {
            sum2 += matrix[i][j];
        }
        System.out.println("Tổng đường chéo ngược của ma trận: " + sum2);
    }
}
