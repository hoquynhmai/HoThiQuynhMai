package _16_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFile {

    public static void writeObject() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Work\\CodeGym\\Class\\C0620G1\\Module_2\\SourceDemo\\src\\codegym\\_16_binary_file\\student.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//          BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(objectOutputStream);


            List<Student> studentList = new ArrayList<>();
            studentList.add(new Student(1, "NguyenA"));
            studentList.add(new Student(2, "NguyenB"));
            studentList.add(new Student(3, "NguyenC"));

            objectOutputStream.writeObject(studentList);

            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readObject(){
        try {
            FileInputStream fileInputStream =  new FileInputStream("D:\\Work\\CodeGym\\Class\\C0620G1\\Module_2\\SourceDemo\\src\\codegym\\_16_binary_file\\student.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            List<Student> studentList = (List<Student>) objectInputStream.readObject();

            for(Student student: studentList){
                System.out.println(student);
            }

            objectInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        writeObject();
        readObject();
    }
}
