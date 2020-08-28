package furama_resort.controllers;

import java.util.Scanner;

public class MainController {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int chon = 0;
        do {
            System.out.println("-------------Menu-----------------\n1.Add New Services\n2.Show Services\n3.Add New Customer\n4.Show Information of Customer\n5.Add New Booking\n6.Show Information of Employee\n7.Exit\n-----------------------------------");
            System.out.print("Chọn: ");
            String chonMenu = input.nextLine();
            if (kiemTraSoNguyen(chonMenu)) {
                chon = Integer.parseInt(chonMenu);
                switch (chon) {
                    case 1:
                        addNewServices();
                        break;
                    case 2:
                        //showServices();
                        break;
                    case 3:
                        //addNewCustomer();
                        break;
                    case 4:
                        //showInfoCustomer();
                        break;
                    case 5:
                        //addNewBooking();
                        break;
                    case 6:
                        //showInfoEmployee();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sự lựa chọn không tồn tại. Bạn cần chọn lại");
                }
            } else System.out.println("Lựa chọn không tồn tại");
        } while (true);
    }

    public static boolean kiemTraSoNguyen(String chon) {
        return chon.matches("^\\d");
    }

    public static void addNewServices() {
        int chon = 0;
        do {
            System.out.println("-------------Menu-----------------\n1.Add New Villa\n2.Add New House\n3.Add New Room\n4.Back to Menu\n5.Exit\n-----------------------------------");
            System.out.print("Chọn: ");
            String chonMenu = input.nextLine();
            if (kiemTraSoNguyen(chonMenu)) {
                chon = Integer.parseInt(chonMenu);
                switch (chon) {
                    case 1:
                        //addNewVilla();
                        break;
                    case 2:
                        //addNewHouse();
                        break;
                    case 3:
                        //addNewRoom();
                        break;
                    case 4:
                        displayMainMenu();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sự lựa chọn không tồn tại. Bạn cần chọn lại");
                }
            } else System.out.println("Lựa chọn không tồn tại");
        } while (true);
    }

}
