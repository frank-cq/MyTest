package test016;

import common.BTNode;

import java.util.ArrayList;

/**
 * Created by cq on 2015/4/20.
 * 第16题：输入一棵二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。
 */
public class Test016 {
    //层序遍历，依然是BFS的思想
    public static void levelorderTraversal(BTNode bTree){
        if (bTree == null){
            return;
        }

        BTNode currentBTNode = null;
        //使用ArrayList建一个队列，保存还未被遍历到的子树
        ArrayList<BTNode> untraversedBTrees = new ArrayList<BTNode>();
        untraversedBTrees.add(bTree);

        //只要存在未被遍历的子树，就继续循环
        while (!untraversedBTrees.isEmpty()){
            //取出第一个子树
            currentBTNode = untraversedBTrees.get(0);
            untraversedBTrees.remove(0);

            BTNode curLeft = currentBTNode.getLeft();
            BTNode curRight = currentBTNode.getRight();

            //向队列中添加新发现的子树
            if (curLeft != null){
                untraversedBTrees.add(curLeft);
            }
            if (curRight != null){
                untraversedBTrees.add(curRight);
            }
            System.out.print(currentBTNode.getValue()+" ");
        }
    }
    public static void main(String[] args){
        BTNode bTree = new BTNode(8);
        BTNode node2 = new BTNode(6);
        BTNode node3 = new BTNode(10);
        BTNode node4 = new BTNode(5);
        BTNode node5 = new BTNode(7);
        BTNode node6 = new BTNode(9);
        BTNode node7 = new BTNode(11);
        bTree.setLeft(node2);
        bTree.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);

        levelorderTraversal(bTree);
        System.out.println();
    }
}
