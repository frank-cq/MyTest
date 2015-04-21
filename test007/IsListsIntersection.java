package test007;

/**
 * Created by cq on 2015/3/31.
 * 第7题：给出两个单向链表的头指针，比如h1，h2，判断这两个链表是否相交。假设两链表不带环。
 */
public class IsListsIntersection {
    //比较最后一个节点是否是同一个节点，无环情况
    public static boolean isListsInters(Node h1, Node h2){
        if (h1 == null || h2 == null){
            return false;
        }
        while (h1.getNext() != null){
            h1 = h1.getNext();
        }
        while (h2.getNext() != null){
            h2 = h2.getNext();
        }
        return h1 == h2;
    }

    //求出第一个相交节点，即得出相交的节点列，无环情况
    public static Node getFirstIntersList(Node h1, Node h2){
        //计算两个链表之间的长度差距
        int distance = Node.getLength(h1) - Node.getLength(h2);
        //对较长的链表进行移动，直到两者长度一致
        if (distance > 0){
            h1 = IsListsIntersection.movePosD(h1,distance);
        }else{
            h2 = IsListsIntersection.movePosD(h2,distance);
        }
        //从头开始，对节点进行逐对比较
        while ( h1 != null && h2 != null){
            if (h1 == h2){
                return h1;
            }
            h1 = h1.getNext();
            h2 = h2.getNext();
        }
        return null;
    }
    // 将指针后移dis个位置
    public static Node movePosD(Node h, int dis){
        while (h != null && dis >0){
            h = h.getNext();
            dis--;
        }
        return h;
    }
    // 打印链表
    public static void printList(Node h){
        while (h != null){
            System.out.print(h.getData()+" ");
            h = h.getNext();
        }
    }

    // 判断可能有环列的两链表是否相交
    public static boolean isListsIntersR(Node h1, Node h2){
        Node[] cycleInfOfH1 = cycleInf(h1), cycleInfOfH2 = cycleInf(h2);

        //一个有环，一个无环；或者两者环的长度不相等
        if ((cycleInfOfH1 != null && cycleInfOfH2 == null) || (cycleInfOfH1 == null && cycleInfOfH2 != null) || cycleInfOfH1[1].getData() != cycleInfOfH2[1].getData()){
            return false;
        }
        //两个都无环
        else if (cycleInfOfH1 == null && cycleInfOfH2 == null){
            return isListsInters(h1,h2);
        }
        else {
           int cycleLen = cycleInfOfH1[1].getData();
           Node cycleNodeOfH1 = cycleInfOfH1[0];
           while (cycleLen > 0){
               if (cycleNodeOfH1 == cycleInfOfH2[0]){
                   return true;
               }
               cycleNodeOfH1 = cycleNodeOfH1.getNext();
               cycleLen--;
           }
        }
        return false;
    }
    /*
     * 判断链表是否有环：若无，返回null；若有，返回两个Node，一个存放环内一节点，另一个存放环长度。
     * 设h1以1的速度后移，h2以2的速度后移，类似追及问题，以h1为参照系，则h1速度为0，h2的速度为1，
     * 若存在环（绕圈跑），在某一时间，h2总能追上h1，且第一次追上时，h2恰巧比h1多移动了1个环的长度。
     * 若不存在环，则到尾节点就结束
     */
    public static Node[] cycleInf(Node h){
        Node h1 = h, h2 = h;
        int len1 = 0 , len2 = 0;
        Node[] arr = new Node[2];
        while (h1.getNext() != null && h2.getNext() != null && h2.getNext().getNext() != null){
            h1 = h1.getNext();
            h2 = h2.getNext().getNext();
            len1++;
            len2 += 2;
            if (h1 == h2){
                arr[0] = h1;
                arr[1] = new Node(len2 - len1);
                return arr;
            }
        }
        return null;
    }
    public static void main(String[] args){
        Node h1 = new Node(1);
        Node n2 = new Node(2);
        Node h2 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
//        h1.setNext(n2);
//        n2.setNext(n4);
//        h2.setNext(n4);
//        n4.setNext(n5);
//        System.out.println("h1与h2相交："+IsListsIntersection.isListsInters(h1,h2));
//        Node commonList = IsListsIntersection.getFirstIntersList(h1,h2);
//        IsListsIntersection.printList(commonList);

        Node h3 = new Node(7);
        Node n8 = new Node(8);
        h3.setNext(n8);

        h1.setNext(n2);
        n2.setNext(n4);
        h2.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n4);
        System.out.println("h1与h2相交："+IsListsIntersection.isListsIntersR(h1,h2));
        System.out.println("h1与h3相交："+IsListsIntersection.isListsIntersR(h1,h3));

    }
}
