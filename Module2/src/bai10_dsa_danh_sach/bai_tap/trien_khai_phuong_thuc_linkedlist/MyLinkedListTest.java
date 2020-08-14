package bai10_dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList linkedList = new MyLinkedList(10);
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(5);
        linkedList.addFirst(7);
        linkedList.addFirst(3);
        linkedList.addFirst(4);

        linkedList.add(4, 9);
        linkedList.add(4, 9);
        linkedList.remove(3);

        linkedList.printList();
    }
}
