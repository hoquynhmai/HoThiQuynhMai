package bai12_java_collection_framework.bai_tap.optional.cai_dat_thao_tac_duyet_thu_tu_postorder_trong_bst;

public class DuyetBST<E extends Comparable<E>> {
    public TreeNode<E> root;
    protected int size;

    public DuyetBST() {
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


}
