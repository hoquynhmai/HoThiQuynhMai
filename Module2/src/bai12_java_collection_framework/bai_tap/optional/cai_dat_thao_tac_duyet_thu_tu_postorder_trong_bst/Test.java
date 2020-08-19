package bai12_java_collection_framework.bai_tap.optional.cai_dat_thao_tac_duyet_thu_tu_postorder_trong_bst;

public class Test {
    public static void main(String[] args) {
        DuyetBST<String> test = new DuyetBST<>();
//        test.insert("George");
//        test.insert("Michael");
//        test.insert("Tom");
//        test.insert("Adam");
//        test.insert("Jones");
//        test.insert("Peter");
//        test.insert("Daniel");

        test.insert("15");
        test.insert("20");
        test.insert("85");
        test.insert("70");
        test.insert("25");
        test.insert("30");
        test.insert("49");

        System.out.println("1.Inorder: ");
        test.inorder( );
        System.out.println("\nThe number of nodes is: " + test.getSize());

        System.out.println("\n2.Postorder: ");
        test.postorder();
        System.out.println("The number of nodes is: " + test.getSize());

        System.out.println("\n3.Preorder: ");
        test.preorder();
        System.out.println("\nThe number of nodes is: " + test.getSize());
    }
}
