package bai9_automated_testing_and_tdd.bai_tap.tinh_ngay_tiep_theo;

public class NextDayCalculator {
    //    public static int nextDay(int day,int month, int year){
//    }

    public boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public void dayInMonth(int month, int year) {
        int dayOfMonth;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayOfMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayOfMonth = 30;
                break;
            case 2:
                if (isLeapYear(year)) {
                    dayOfMonth = 29;
                } else {
                    dayOfMonth = 28;
                }
                break;
        }
    }

//    public boolean isSuitable(int day, int month, int year) {
//        if (!(year > 0)) {
//            return false;
//        } else if (!(month >= 1 && month <= 12)) {
//            return false;
//        } else if (!(day >= 1 && day <= dayInMonth(month, year))) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//    public int findDayAfter(int day, int month, int year){
//        if(day > dayInMonth(month,year)){
//            day = 1;
//            month += 1;
//        }
//    }
}
// Sai rồi
