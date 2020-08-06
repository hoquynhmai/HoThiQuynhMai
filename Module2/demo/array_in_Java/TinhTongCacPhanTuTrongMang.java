package codegym._3_array_method;

public class MyArray {
    //khai bao
    static int[] array_1 = {1, 2, 3, 4, 5};
    static int array_2[] = new int[10];
    static String[] array_3 = new String[10];


    public static void sumElementArray(int[] myArray){
        int sum = 0;
        for(int i=0; i<myArray.length;i++){
            sum += myArray[i];
        }
        System.out.println("Sum: "+sum);
    }

    public static int sumElementArray_2(int[] myArray){
        int sum = 0;
        for(int i=0; i<myArray.length;i++){
            sum += myArray[i];
        }
        return sum;
    }

    public static void sumElementArray_3(){
        int sum = 0;
        for(int i=0; i<array_1.length;i++){
            sum += array_1[i];
        }
        System.out.println("Sum: "+sum);
    }

    public static void main(String[] args) {
        sumElementArray_3();



//        for (int element : array_1) {
//            System.out.println(element);
//        }

//        int i = 0;
//        while (i < array_1.length) {
//            System.out.println(array_1[i]);
//            i++;
//        }
    }


}
