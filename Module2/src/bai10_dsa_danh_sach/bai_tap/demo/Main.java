package bai10_dsa_danh_sach.bai_tap.demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst("A");
        myLinkedList.addFirst("B");
        myLinkedList.addFirst("C");
        myLinkedList.addFirst("D");
        myLinkedList.printList();
        System.out.println(myLinkedList.contains("E"));
        MyLinkedList<String> myLinkedList2 = myLinkedList.clone();
        System.out.println("=============");
        myLinkedList2.printList();
        System.out.println(null instanceof Object);
    }
}
