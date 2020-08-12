package bai9_automated_testing_and_tdd.bai_tap.tinh_ngay_tiep_theo;

import java.util.Scanner;

public class NextDayCalculator {
    public static void main(String[] args) {
        int day;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a day: ");
            day = input.nextInt();

            System.out.println("Enter a month: ");
            int month = input.nextInt();

            System.out.println("Enter a year: ");
            int year = input.nextInt();

            System.out.println("-> Ngày hiện tại: " + day + "/" + month + "/" + year);

            if (laNgayHopLe(day, month, year)) {
                int tempDay = day;
                int tempMonth = month;
                int tempYear = year;

                tempDay = day;
                tempMonth = month;
                tempYear = year;
                System.out.println(timNgayHomSau(tempDay, tempMonth, tempYear));
            } else {
                System.out.println("Không hợp lệ");
            }
        }while (day != 0);
    }
    // hàm kiểm tra năm nhuận:
    public static boolean laNamNhuan(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
    // hàm trả về số ngày và năm cho trước:
    public static int timSoNgayTrongThang(int month, int year) {
        int numOfDay = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numOfDay = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numOfDay = 30;
                break;
            case 2:
                if (laNamNhuan(year)) {
                    numOfDay = 29;
                } else {
                    numOfDay = 28;
                }
                break;
        }
        return numOfDay;
    }
    public static boolean laNgayHopLe(int day, int month, int year) {
        boolean result = true;
        /*kiểm tra năm: */
        if (!(year > 0 && month > 0)) {
            result = false;
        }
        /*kiểm tra tháng: */
        if (!(month > 0 && month <= 12)) {
            result = false;
        }
        /*kiểm tra ngày: */
        if (!(day > 0 && day <= timSoNgayTrongThang(month, year))) {
            result = false;
        }
        return result;
    }

    public static String timNgayHomSau(int day, int month, int year)
    {
        String result= " ";
        int tempDay = ++day;
        int tempMonth = month;
        int tempYear = year;
        if (day > timSoNgayTrongThang(month, year))
        {
            day = 1;
            tempMonth = ++month;
            if (month > 12)
            {
                month = 1;
                tempYear = ++year;
            }
            tempDay = timSoNgayTrongThang(month,year);
        }
        result = Integer.toString(tempDay) + "/" + Integer.toString(tempMonth) + "/" + Integer.toString(tempYear);
        return result;
    }
}
