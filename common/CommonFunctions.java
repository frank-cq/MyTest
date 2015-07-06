package common;


/**
 * Created by cq on 2015/4/18.
 * 此处放置一些公共的方法
 */
public class CommonFunctions {
    //二叉树的中序遍历
    public static void inorderTraversal(BTNode bTree){
        if (bTree == null){
            return;
        }
        inorderTraversal(bTree.getLeft());
        System.out.print(bTree.getValue()+" ");
        inorderTraversal(bTree.getRight());
    }

    //按层次遍历的顺序初始化一棵二叉树
    public static BTNode initBTree(int[] arr){
        return null;
    }

    //打印数组
    public static <T> void printPartArray(T[] array, int maxIndex){
        for (int i=0; i<=maxIndex; i++){
            if (array[i] != null){
                System.out.print(array[i]+" ");
            }
        }
        System.out.println();
    }

    //打印数组
    public static <T> void printArray(T[] array){
        for (T t : array){
            System.out.print(t + " ");
        }
        System.out.println();
    }

    //打印链表
    public static void printList(Node list){
        while (list != null){
            System.out.print(list.getData()+" ");
            list = list.getNext();
        }
        System.out.println();
    }

    //简单整数的乘方
    public static int pow(int n, int power){
        int result = 1;
        if (n < 0 || power < 1){
            return result;
        }

        while (power > 0){
            result *= n;
            power--;
        }
        return result;
    }
}
