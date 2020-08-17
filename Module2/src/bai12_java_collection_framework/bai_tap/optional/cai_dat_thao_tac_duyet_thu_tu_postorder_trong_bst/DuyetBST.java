package bai12_java_collection_framework.bai_tap.optional.cai_dat_thao_tac_duyet_thu_tu_postorder_trong_bst;

import org.w3c.dom.Node;

public class DuyetBST {
    int data;
    Node left;
    Node right;

    public void postorder(Node root) {
        if (left != null) {
            postOrderPrint(left);
        }
    }

    private void postOrderPrint(Node left) {
    }
}
