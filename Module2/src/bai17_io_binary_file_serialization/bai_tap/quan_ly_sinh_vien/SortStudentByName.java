package bai17_io_binary_file_serialization.bai_tap.quan_ly_sinh_vien;

import java.util.Comparator;

public class SortStudentByName implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getName().compareTo(student2.getName());
    }
}
