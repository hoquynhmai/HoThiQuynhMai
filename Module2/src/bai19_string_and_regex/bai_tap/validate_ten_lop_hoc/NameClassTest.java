package bai19_string_and_regex.bai_tap.validate_ten_lop_hoc;

public class NameClassTest {
    private static NameClass nameClass;
    private static final String[] validNameClass = new String[]{"C0318G"};
    private static final String[] invalidNameClass = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args) {
        nameClass = new NameClass();
        for (String name : validNameClass) {
            boolean isvalid = nameClass.validate(name);
            System.out.println("Tên lớp " + name + " là hợp lệ: " + isvalid);
        }
        for (String name : invalidNameClass) {
            boolean isvalid = nameClass.validate(name);
            System.out.println("Tên lớp " + name + " là hợp lệ: " + isvalid);
        }
    }
}
