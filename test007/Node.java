package test007;

/**
 * Created by cq on 2015/3/31.
 * 节点的类定义
 */
public class Node {
    private int data;
    private Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
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

    public static int getLength(Node list){
        int len = 0;
        while (list != null){
            len++;
            list = list.getNext();
        }
        return len;
    }
}
