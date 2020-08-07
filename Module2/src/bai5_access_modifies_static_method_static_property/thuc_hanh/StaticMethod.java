package bai5_access_modifies_static_method_static_property.thuc_hanh;

public class StaticMethod {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    //constructor to initialize the variable
    StaticMethod(int r, String n) {
        rollno = r;
        name = n;
    }

    //static method to change the value of static variable
    static void change() {
        college = "CODEGYM";
    }

    //method to display values
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
