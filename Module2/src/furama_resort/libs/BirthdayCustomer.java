package furama_resort.libs;

import furama_resort.models.Customer;
import java.util.Comparator;

public class BirthdayCustomer implements Comparator<Customer> {
    //So sánh năm sinh
    @Override
    public int compare(Customer khach1, Customer khach2) {
        //dd/mm/yyyy
        int namSinh1 = Integer.parseInt(khach1.getNgaySinh().substring(6,10));
        int namSinh2 = Integer.parseInt(khach2.getNgaySinh().substring(6,10));
        return namSinh1 - namSinh2;
    }
}
