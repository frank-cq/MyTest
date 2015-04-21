package test004;

/**
 * Created by cq on 2015/3/29.
 * 第四题：输入一个整数和一颗二叉树。从树的根节点开始往下访问一直到叶结点所经过的结点
 *        形成一条路径。打印出和与输入整数相等的所有路径。
 * 要求：  无
 * 注：   二叉树的结点的值不是有序的，所有的结点都需要遍历到
 */
public class PathOfTree {
    public static void getPathOfBTree(int num, Node tree){
        pathOfBTree(num,tree,"");
    }
    public static void pathOfBTree(int num, Node tree, String path){
        if (tree == null || tree.getValue() > num){
            return;
        }
        if (tree.getLeft() == null && tree.getRight() == null && tree.getValue() == num){
            System.out.println(path+tree.getValue());
            return;
        }
        pathOfBTree(num-tree.getValue(), tree.getLeft(), path+tree.getValue()+" ");
        pathOfBTree(num-tree.getValue(), tree.getRight(), path+tree.getValue()+" ");
    }
    public static void main(String[] args){
        Node n1 = new Node(10);
        Node n2 = new Node(5);
        Node n3 = new Node(12);
        Node n4 = new Node(4);
        Node n5 = new Node(7);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);

        PathOfTree.getPathOfBTree(22,n1);
    }
}
