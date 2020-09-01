package furama_resort.libs;

import furama_resort.models.Customer;
import java.util.Comparator;

public class NameCustomer implements Comparator<Customer> {

    @Override
    public int compare(Customer khach1, Customer khach2) {
        int soSanhTen = khach1.getHoTen().compareTo(khach2.getHoTen());
        return soSanhTen;
    }
}
