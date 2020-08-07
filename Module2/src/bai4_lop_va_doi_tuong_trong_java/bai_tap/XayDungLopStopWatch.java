package bai4_lop_va_doi_tuong_trong_java.bai_tap;

import java.util.Arrays;

public class XayDungLopStopWatch {
    private long startTime;
    private long endTime;

    public XayDungLopStopWatch() {
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    void start() {
        startTime = System.currentTimeMillis();
    }

    void end() {
        endTime = System.currentTimeMillis();
    }

    long getElapsedTime() {
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        XayDungLopStopWatch stopWatch = new XayDungLopStopWatch();
        stopWatch.start();
        Arrays.sort(array);
        stopWatch.end();
        System.out.println(stopWatch.getElapsedTime());
    }
}
// Bài Demo