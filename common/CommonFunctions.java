package common;


/**
 * Created by cq on 2015/4/18.
 * 此处放置一些公共的方法
 */
public class CommonFunctions {
    //二叉树的中序遍历
    public static void inorderTraversal(BTNode bTree){
        if (bTree == null){
            return;
        }
        inorderTraversal(bTree.getLeft());
        System.out.print(bTree.getValue()+" ");
        inorderTraversal(bTree.getRight());
    }

    //按层次遍历的顺序初始化一棵二叉树
    public static BTNode initBTree(int[] arr){
        return null;
    }
}
