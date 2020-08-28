package class_and_object;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        for (int i =0 ; i < array.length; i++){
            array[i] = (int)(Math.random()*1000000+1);
        }
        DemoStopWatch stopWatch = new DemoStopWatch();
        stopWatch.start();
        Arrays.sort(array);
        stopWatch.end();
        System.out.println(stopWatch.getElapsedTime());
    }
}
