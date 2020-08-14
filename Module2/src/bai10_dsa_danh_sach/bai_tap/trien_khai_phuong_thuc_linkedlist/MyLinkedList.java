package bai10_dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_linkedlist;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes;

    public MyLinkedList() {
    }

    public MyLinkedList(E element) {
        head = new Node(element);
        numNodes++;
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= numNodes) addLast(e);
        else {
            Node current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node temp = current.next;
            current.next = new Node(e);
            (current.next).next = temp;
            numNodes++;
        }
    }

    public void addFirst(E element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        numNodes++;

        if (tail == null)
            tail = head;
    }

    public void addLast(E element) {
        Node newNode = new Node(element);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        numNodes++;
    }

    public E removeFirst() {
        if (numNodes == 0) return null;
        else {
            Node temp = head;
            head = head.next;
            numNodes--;
            if (head == null) tail = null;
            return (E) temp.data;
        }
    }

    public E removeLast() {
        if (numNodes == 0) return null;
        else if (numNodes == 1) {
            Node temp = head;
            head = tail = null;
            numNodes = 0;
            return (E) temp.data;
        } else {
            Node current = head;

            for (int i = 0; i < numNodes - 2; i++)
                current = current.next;

            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return (E) temp.data;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) return null;
        else if (index == 0) return removeFirst();
        else if (index == numNodes - 1) return removeLast();
        else {
            Node previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return (E) current.data;
        }
    }

    public int size() {
        return numNodes;
    }

    //    public boolean contains(E o) {
//        for (int i = 0; i < numNodes; i++)
//            if (o.equals(head[i])) {
//                return true;
//            }
//        return false;
//    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
