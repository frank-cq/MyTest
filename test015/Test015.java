package test015;

import common.BTNode;
import common.CommonFunctions;

import java.util.ArrayList;

/**
 * Created by cq on 2015/4/18.
 * 第15题：输入一颗二元查找树，将该树转换为它的镜像，即在转换后的二元查找树中，左子树的结点都大于右子树的结点。
 * 要求：  使用递归和循环两种方法完成树的镜像转换。
 */
public class Test015 {

    //递归方式实现的二叉搜索树镜像功能
    public static void mirrorBTreeRecursion(BTNode bTree){
        if (bTree == null || (bTree.getLeft() == null && bTree.getRight() == null)){
            return;
        }

        mirrorBTreeRecursion(bTree.getLeft());
        mirrorBTreeRecursion(bTree.getRight());

        BTNode temp = bTree.getLeft();
        bTree.setLeft(bTree.getRight());
        bTree.setRight(temp);
    }

    //循环方式实现的二叉搜索树镜像功能，类似于图的BFS搜索
    public static void mirrorBTreeLoop(BTNode bTree){
        if (bTree == null){
            return;
        }

        BTNode currentBTNode = null;
        //使用ArrayList建一个队列，保存还未被镜像的子树
        ArrayList<BTNode> unmirroredBTrees = new ArrayList<BTNode>();
        unmirroredBTrees.add(bTree);

        //只要存在未被镜像的子树，就继续循环
        while (!unmirroredBTrees.isEmpty()){
            //取出第一个子树
            currentBTNode = unmirroredBTrees.get(0);
            unmirroredBTrees.remove(0);

            BTNode curLeft = currentBTNode.getLeft();
            BTNode curRight = currentBTNode.getRight();

            //向队列中添加新发现的子树
            if (curLeft != null){
                unmirroredBTrees.add(curLeft);
            }
            if (curRight != null){
                unmirroredBTrees.add(curRight);
            }

            //左右交换
            currentBTNode.setLeft(curRight);
            currentBTNode.setRight(curLeft);
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

        System.out.print("使用递归方法镜像之前二叉搜索树的中序序列：");
        CommonFunctions.inorderTraversal(bTree);
        System.out.println();
        mirrorBTreeRecursion(bTree);
        System.out.print("使用递归方法镜像之后二叉搜索树的中序序列：");
        CommonFunctions.inorderTraversal(bTree);
        System.out.println();

        System.out.print("使用循环方法镜像之前二叉搜索树的中序序列：");
        CommonFunctions.inorderTraversal(bTree);
        System.out.println();
        mirrorBTreeLoop(bTree);
        System.out.print("使用循环方法镜像之后二叉搜索树的中序序列：");
        CommonFunctions.inorderTraversal(bTree);
        System.out.println();
    }
}
