package furama_resort.libs;

import furama_resort.models.Customer;

import java.util.Comparator;

public class SapXepHoTenKhach implements Comparator<Customer> {

    // So sánh tên, nếu tên giống nhau so sánh năm sinh (dd/mm/yyyy)
    @Override
    public int compare(Customer khach1, Customer khach2) {
        int soSanhTen = khach1.getHoTen().compareTo(khach2.getHoTen());
        if (soSanhTen == 0) {
            int namSinh1 = Integer.parseInt(khach1.getNgaySinh().substring(6,10));
            int namSinh2 = Integer.parseInt(khach2.getNgaySinh().substring(6,10));
            return namSinh1 - namSinh2;
        } else
            return soSanhTen;
    }
}
