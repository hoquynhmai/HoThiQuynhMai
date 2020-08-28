package codegym._15_io_text_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static final String COMMA = ",";

    public static void writeCVS(Student student) {
        File file = new File("D:\\Work\\CodeGym\\Class\\C0620G1\\Module_2\\SourceDemo\\src\\codegym\\_15_io_text_file\\student.csv");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(student.getId()).append(COMMA).append(student.getName()).append("\n");
            buffWrite.write(stringBuilder.toString());

//            buffWrite.write(String.valueOf(student.getId())+COMMA+student.getName()+"\n");
//            buffWrite.write(COMMA);
//            buffWrite.write(student.getName());
//            buffWrite.write("\n");

            buffWrite.flush();
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readCSV() {
        List<Student> studentList = new ArrayList<>();
        File file = new File("D:\\Work\\CodeGym\\Class\\C0620G1\\Module_2\\SourceDemo\\src\\codegym\\_15_io_text_file\\student.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffRead = new BufferedReader(fileReader);
            String line;
            String[] temp;
            Student student;
            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                student = new Student(Integer.parseInt(temp[0]), temp[1]);
                studentList.add(student);
            }
            buffRead.close();
            return studentList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static void main(String[] args) {
        Student student_1 = new Student(1, "Khanh");
        Student student_2 = new Student(2, "Quan");
        Student student_3 = new Student(3, "Lanh");

//        writeCVS(student_1);
//        writeCVS(student_2);
//        writeCVS(student_3);

        List<Student> studentList = readCSV();
        for (Student student: studentList){
            System.out.println(student);
        }
    }
}
