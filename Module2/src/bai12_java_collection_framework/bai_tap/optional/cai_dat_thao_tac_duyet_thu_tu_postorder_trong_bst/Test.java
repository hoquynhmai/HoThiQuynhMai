package bai12_java_collection_framework.bai_tap.optional.cai_dat_thao_tac_duyet_thu_tu_postorder_trong_bst;

public class Test {
    public static void main(String[] args) {
        DuyetBST<Integer> test = new DuyetBST<>();

        test.insert(15);
        test.insert(20);
        test.insert(85);
        test.insert(70);
        test.insert(25);
        test.insert(30);
        test.insert(49);

        System.out.println("1.Inorder: ");
        test.inorder();
        System.out.println("\nThe number of nodes is: " + test.getSize());

        System.out.println("\n2.Postorder: ");
        test.postorder();
        System.out.println("The number of nodes is: " + test.getSize());

        System.out.println("\n3.Preorder: ");
        test.preorder();
        System.out.println("\nThe number of nodes is: " + test.getSize());

        System.out.println("\n4.Xóa Node: ");
        test.remove(25);
        test.inorder();
        System.out.println("\nThe number of nodes is: " + test.getSize());

        System.out.println("\n5.Tìm kiếm: ");
        System.out.println(test.search(49));
        test.inorder();
    }
}
