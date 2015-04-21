package test013;

import test007.Node;

/**
 * Created by cq on 2015/4/11.
 * 第13题：输入一个单向链表，输出该链表中倒数第K个结点。链表的倒数第0个结点为链表的尾指针。
 */
public class Test013 {
    public static Node getLastKNode(Node list, int k){
        if (list == null || k < 0){
            return null;
        }

        Node anchor = list;
        int index = 0;
        while (list != null){
            //在anchor和list之间拉开k个结点的距离
            if (index < k){
                list = list.getNext();
                index++;
                continue;
            }
            anchor = anchor.getNext();
            list = list.getNext();
        }

//        //链表长度不到k
//        if (index < k){
//            anchor = null;
//        }

        return anchor;
    }
    public static void main(String[] args){
        Node list = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        list.setNext(node4);
        node4.setNext(node3);
        node3.setNext(node2);
        node2.setNext(node1);

        System.out.println("倒数第2个结点是："+getLastKNode(list, 2).getData());
        System.out.println("倒数第4个结点是："+getLastKNode(list, 4).getData());

        System.out.println("倒数第7个结点是："+getLastKNode(list, 7).getData());
        System.out.println("倒数第10个结点是："+getLastKNode(list, 10).getData());
    }
}
