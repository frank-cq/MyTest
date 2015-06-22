package test024;

import common.CommonFunctions;
import common.Node;

import java.util.LinkedList;

/**
 * Created by cq on 2015/6/22.
 * 第24题：原地单链表逆置
 */
public class Test024 {
    //原地逆置单链表
    public static Node inverseLinkedList(Node linkedList){
        if (Node.getLength(linkedList) < 2){
            return linkedList;
        }

        Node previous = null;
        Node next = linkedList.getNext();
        linkedList.setNext(previous);

        while (next != null){
            previous = linkedList;
            linkedList = next;
            next = next.getNext();

            linkedList.setNext(previous);
        }

        return linkedList;
    }

    public static void main(String[] args){
        Node linkedList = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        linkedList.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        System.out.print("逆置前单链表为：");
        CommonFunctions.printList(linkedList);
        linkedList = inverseLinkedList(linkedList);
        System.out.print("逆置后单链表为：");
        CommonFunctions.printList(linkedList);
    }
}
