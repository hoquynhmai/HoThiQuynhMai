package bai19_string_and_regex.bai_tap.validate_so_dien_thoai;

public class NumberPhoneTest {
    private static NumberPhone numberPhone;
    private static final String[] validNumberPhone = {"(84)-(0978489648)"};
    private static final String[] invalidNumberPhone = {"(a8)-(22222222)","(84))-(0978489648)"};

    public static void main(String[] args) {
        numberPhone = new NumberPhone();
        for(String number: validNumberPhone){
            boolean isvalid = numberPhone.validate(number);
            System.out.println("Số điện thoại " + number + " là số hợp lệ: " + isvalid);
        }
        for(String number: invalidNumberPhone){
            boolean isvalid = numberPhone.validate(number);
            System.out.println("Số điện thoại " + number + " là số hợp lệ: " + isvalid);
        }
    }
}
