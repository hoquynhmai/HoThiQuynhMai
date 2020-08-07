package bai4_lop_va_doi_tuong_trong_java.bai_tap;

public class BuildClassFan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 1;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public BuildClassFan(){

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public String toString(){
        if (on == true){
            return ("Tốc độ quạt: " + speed + " _ Màu sắc quạt: " + color + " _ Bán kính quạt: " + radius + " _ Quạt đang chạy");
        } else {
            return ("Màu sắc quạt: " + color + " _ Bán kính quạt: " + radius + " _ Quạt đã tắt");
        }
    }

    public static void main(String[] args) {
        BuildClassFan fan1 = new BuildClassFan();
        fan1.setSpeed(3);
        fan1.setColor("yellow");
        fan1.setRadius(10);
        fan1.setOn(true);
        System.out.println("Fan 1: " + fan1.toString());

        BuildClassFan fan2 = new BuildClassFan();
        System.out.println("Fan 2: " + fan2.toString());
    }
}
