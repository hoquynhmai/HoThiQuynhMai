package bai11_dsa_stack_queue.bai_tap.trien_khai_queue_su_dung_danh_sach_lien_ket_vong;

public class Solution {
    public static void enqueue(Queue queue, int value) {
        Node temp = new Node();
        temp.data = value;
        if (queue.front == null)
            queue.front = temp;
        else
            queue.rear.link = temp;

        queue.rear = temp;
        queue.rear.link = queue.front;
    }

    public static Object dequeue(Queue queue) {
        if (queue.front == null) {
            return null;
        }
        Object value;
        if (queue.front == queue.rear) {
            value = queue.front.data;
            queue.front = null;
            queue.rear = null;
        } else {
            Node temp =  queue.front;
            value = temp.data;
//            temp.data = (int) value;
            queue.front =  queue.front.link;
            queue.front.link =  queue.front;
        }
        return value;
    }

    public static void displayQueue(Queue queue){
        Node  temp = queue .front;
        System.out.printf("Các phần tử trong Hàng đợi hình tròn là: ");
        while (temp .link != queue .front) {
            System.out.printf("%d ", temp .data);
            temp = temp .link;
        }
        System.out.printf("%d ", temp .data);
    }

    public static void main(String[] args) {
        Queue  queue = new Queue();

        //Thêm phần tử vào cuối Queue
        enqueue(queue,100);
        enqueue(queue,99);
        enqueue(queue,11);
        enqueue(queue,15);
        enqueue(queue,77);
        displayQueue(queue);

        //Xóa phần tử đầu của Queue
        System.out.println();
        System.out.println("Giá trị cần xóa = " + dequeue(queue));
        System.out.println("Giá trị cần xóa = " + dequeue(queue));
    }
}
