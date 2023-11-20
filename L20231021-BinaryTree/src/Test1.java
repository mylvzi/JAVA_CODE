import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-10-21
 * Time: 19:15
 */
public class Test1 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.create();
        binaryTree.preOrder(root);
        System.out.println("==============");
        binaryTree.preOrderNor(root);
        System.out.println("=====");
        binaryTree.inOrder(root);
        System.out.println("=====");
        binaryTree.inOrderNor(root);
//        System.out.println(binaryTree.iscompleteTree(root));
//        List<List<BinaryTree.TreeNode>> ret = binaryTree.levelOrder2(root);
//
//        System.out.println();
//        binaryTree.levelOrder(root);

//        boolean ret = binaryTree.find(root,'e');
//        if (ret == true) {
//            System.out.println("存在该值");
//        }else {
//            System.out.println("不存在该值");


//        System.out.println(15);












//        System.out.println(binaryTree.getKLevelNodeConut(root,3));

//        System.out.println(binaryTree.getHeight(root));

/*        System.out.println(binaryTree.getLeafSize(root));
        System.out.println(binaryTree.getLeafSize2(root));*/
/*        binaryTree.preOrder(root);
        System.out.println();

        List<BinaryTree.TreeNode> ret = binaryTree.preOrder2(root);
        for (BinaryTree.TreeNode x: ret) {
            System.out.print(x.val+" ");
        }

        System.out.println();

        System.out.println(binaryTree.getSize(root));
        System.out.println(binaryTree.getSize2(root));*/

/*
        System.out.println("=====================");

        binaryTree.preOrder(root);

        System.out.println("=====================");
        binaryTree.inOrder(root);

        System.out.println("=====================");
        binaryTree.postOrder(root);
    }*/
    }
}
