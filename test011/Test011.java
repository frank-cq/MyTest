package test011;

import test004.Node;

/**
 * Created by cq on 2015/4/10.
 * 第11题：如果我们把二叉树看成一个图，父子节点之间的连线看成是双向的，我们姑且定义“距离”为两点之间边的个数。
 *        写一个程序，求一棵二叉树中相距最远的两个节点之间的距离。
 */
public class Test011 {
    public static int getMaxDistance(Node bt){
        if (bt == null){
            return 0;
        }
        return MaxDistance(bt)[1];
    }
    //返回一个大小为2的数组，存储以bt为根节点的树的高度和最大节点距离
    public static int[] MaxDistance(Node bt){
        if (bt == null || (bt.getLeft() == null && bt.getRight() == null)){
            return new int[] {0,0};
        }

        int[] disInf = {0,0}, leftDisInf = MaxDistance(bt.getLeft()), rightDisInf = MaxDistance(bt.getRight());
        //返回树高度
        disInf[0] = Math.max(leftDisInf[0]+1,rightDisInf[0]+1);
        //求当前树中的最大距离
        disInf[1] = Math.max(leftDisInf[1],rightDisInf[1]);
        disInf[1] = Math.max(disInf[1],leftDisInf[0]+rightDisInf[0]+2);

        return disInf;
    }
    public static void main(String[] args){
        Node bt = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        bt.setLeft(n1);
        bt.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        System.out.println("当前二叉树最大距离为："+getMaxDistance(bt));

        bt.setRight(null);
        n3.setLeft(n5);
        n4.setLeft(n6);
        System.out.println("当前二叉树最大距离为："+getMaxDistance(bt));
    }
}
