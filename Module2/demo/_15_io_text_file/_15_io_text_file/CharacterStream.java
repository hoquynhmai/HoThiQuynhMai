package codegym._15_io_text_file;

import java.io.*;

public class CharacterStream {
    public static void readFile() {
        File file = new File("D:\\Work\\CodeGym\\Class\\C0620G1\\Module_2\\SourceDemo\\src\\codegym\\_15_io_text_file\\text.txt");

        try {
            FileReader fileReader = new FileReader(file);
            int line = 0;
            int sum = 0;
            while ((line = fileReader.read()) != -1) {
                System.out.println((char) line);
                sum += Integer.parseInt(String.valueOf((char) line));
            }
            System.out.println(sum);

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void buffReadFile() {
        File file = new File("D:\\Work\\CodeGym\\Class\\C0620G1\\Module_2\\SourceDemo\\src\\codegym\\_15_io_text_file\\text.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            System.out.println(sum);
            //bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void buffWriteFile(){
        try {
            FileWriter fileWriter = new FileWriter("D:\\Work\\CodeGym\\Class\\C0620G1\\Module_2\\SourceDemo\\src\\codegym\\_15_io_text_file\\text.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("xin chao!\n Khanh");
            bufferedWriter.append("\ndang hoc lop C06");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        buffWriteFile();
    }
}
