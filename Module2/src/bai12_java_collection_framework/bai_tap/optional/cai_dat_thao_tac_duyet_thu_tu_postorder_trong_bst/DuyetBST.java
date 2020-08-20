package bai12_java_collection_framework.bai_tap.optional.cai_dat_thao_tac_duyet_thu_tu_postorder_trong_bst;

public class DuyetBST<E extends Comparable<E>> {
    public TreeNode<E> root;
    protected int size;

    public DuyetBST() {
        root = null;
    }

    public DuyetBST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    //Duyệt hậu thứ tự
    public void postorder() {
        postorder(root);
    }

    public void postorder(TreeNode<E> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.element + " ");
        }
    }

    //Duyệt tiền thứ tự
    public void preorder() {
        preorder(root);
    }

    public void preorder(TreeNode<E> root) {
        if (root != null) {
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    //Duyệt trung thứ tự
    public void inorder() {
        inorder(root);
    }

    public void inorder(TreeNode<E> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }
    }

    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    public int getSize() {
        return size;
    }

    public void remove(E value) {
        if (root == null) System.out.println("BST is empty !");
        if (deleteNode(root, value) != null) {
            root = deleteNode(root, value);
            size--;
            System.out.println("Đã xóa thành công Node " + value);
        } else System.out.println("Không tìm thấy Node " + value);
    }

    public TreeNode<E> deleteNode(TreeNode<E> root, E value) {
        if (root == null) return null;
        if (value.compareTo(root.element) < 0) {
            root.left = deleteNode(root.left, value);
        } else if (value.compareTo(root.element) > 0) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null) return root.right; // Nút lá hoặc nút cha có 1 nút con bên phải
            else if (root.right == null) return root.left; // Nút lá hoặc nút cha có 1 nút con bên trái
            else { // Nút muốn xóa có 2 nút con thì thay giá trị của nút muốn xóa bằng giá trị của nút có giá trị nhỏ nhất trong nhánh bên phải
                TreeNode<E> temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                } // Tìm nút có giá trị nhỏ nhất bên nhánh phải
                E minAtRight = temp.element;
                root.element = minAtRight; // Gán giá trị cho nút muốn xóa
                root.right = deleteNode(root.right, minAtRight); // Xóa nút có giá trị nhỏ nhất vừa tìm được
            }
        }
        return root;
    }

    public boolean search(E value) {
       return searchMyBST(value, root);
    }

    public boolean searchMyBST(E value, TreeNode<E> root) {
        if (root == null) return false; // Tìm không thấy !
        if (value.compareTo(root.element) < 0) return searchMyBST(value, root.left);
        else if (value.compareTo(root.element) > 0) return searchMyBST(value, root.right);
        else return true; // Tìm thấy !
    }
}
