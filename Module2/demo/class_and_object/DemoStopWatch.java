package Bai1_Introduction_Java.Demo;

public class DemoStopWatch {
    private long startTime;
    private long endTime;

    public DemoStopWatch() {
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
    void start(){
        startTime = System.currentTimeMillis();
    }
    void end(){
        endTime = System.currentTimeMillis();
    }
    long getElapsedTime(){
        return endTime - startTime;
    }
}
