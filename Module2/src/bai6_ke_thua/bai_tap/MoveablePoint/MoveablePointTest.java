package bai6_ke_thua.bai_tap.MoveablePoint;

public class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint_1 = new MoveablePoint();
        System.out.println("1: " + moveablePoint_1);
        System.out.println("move 1: " +   moveablePoint_1.move());
        System.out.println();

        MoveablePoint moveablePoint_2 = new MoveablePoint(1,6);
        System.out.println("2: " + moveablePoint_2);
        System.out.println("move 2: " + moveablePoint_2.move());
        System.out.println();


        MoveablePoint moveablePoint_3 = new MoveablePoint(1, 2, 3,4);
        System.out.println("3: " + moveablePoint_3);
        System.out.println("move 3: " + moveablePoint_3.move());
    }
}
