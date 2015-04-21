package test002;

/**
 * Created by cq on 2015/3/25.
 * 节点node的定义
 */
public class Node {
    private int data;
    private int minData;
    private Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
        this.minData = data;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public int getMinData() {
        return minData;
    }

    public void setMinData(int minData) {
        this.minData = minData;
    }
}
