package bai10_dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    //Tăng kích thước chiều dài mảng
    private void ensureCapa() {
        if (size >= elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    // Thêm một phần tử vào cuối của danh sách
    public void add(int index, E element) {
        ensureCapa();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
            elements[index] = element;
            size++;
        }
    }

    //Kiểm tra chỉ số
    private void CheckIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }

    // Xóa 1 phần tử ra khỏi mảng
    public E remove(int index) {
        CheckIndex(index);
        Object element = elements[index];
        for (int j = index; j < size - 1; j++) {
            elements[j] = elements[j + 1];
            elements[size - 1] = null;
            size--;
        }
        return (E) element;
    }

    //Trả về tổng số lượng phần tử
    public int size() {
        return size;
    }

    //    Trả về một bản sao của ArrayList.
    public Integer clone() {
        size = size / 2;
        return size;
    }

    //Kiểm tra 1 phần tử có nằm trong mảng ko
    public boolean contains(E o) {
        for (int i = 0; i < size; i++)
            if (o.equals(elements[i])) {
                return true;
            }
        return false;
    }

    //Tìm kiếm vị trí xuất hiện đầu tiên của 1 phần tử trong ArrayList.
    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) {
                return i;
            }
        return -1;
    }

    public boolean add(E e) {
        ensureCapa();
        elements[size] = e;
        size++;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (elements.length < minCapacity) {
            elements = Arrays.copyOf(elements, minCapacity);
        }
    }

    // Phương thức get() trả về phần tử vừa ở vị trí thứ i trong danh sách.
    public E get(int i) {
        CheckIndex(i);
        return (E) elements[i];
    }

    //Xóa tất cả các phần tử trong Collection, sau khi thực hiện phương thức này, Collection sẽ rỗng (empty)
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
