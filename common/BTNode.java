package common;

/**
 * Created by cq on 2015/4/18.
 * 二叉树结点定义
 */
public class BTNode {
    private int value;
    private BTNode left;
    private BTNode right;
    public BTNode(int value){
        this.value = value;
        left = null;
        right = null;
    }
    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }
}
