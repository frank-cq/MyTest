package test009;

/**
 * Created by cq on 2015/4/3.
 * 第9题：输入一个整数数组，判断该二叉树是不是某二元查找树的后序遍历的结果。如果是返回true；否则返回false。
 */
public class Test009 {
    public static boolean existCorrespondBSTree(int[] arr){
        if (arr == null){
            return false;
        }
        return childRecursion(arr,0,arr.length-1);
    }
    public static boolean childRecursion(int[] arr, int left, int right){
        //到达叶节点或者空树
        if (left >= right){
            return true;
        }
        int mid = 0;
        boolean leftChildEnd = false;
        for (int i = left ; i<right ; i++){
            //从左到右，遇到第一个比根节点值大的节点，即认为到达左子树边界（右子树起点）
            if (!leftChildEnd && arr[i] > arr[right]){
                mid = i;
                leftChildEnd = true;
            }
            //若在右子树中存在值比根节点小的节点，直接判定为false
            else if (leftChildEnd && arr[i] < arr[right]){
                return false;
            }
        }
        return childRecursion(arr,left,mid-1) && childRecursion(arr,mid,right-1);
    }
    public static void printArray(int[] arr){
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args){
        int[] arr = {5,7,6,9,11,10};
        Test009.printArray(arr);
        System.out.println("是一个二叉查找树的后序序列："+Test009.existCorrespondBSTree(arr)+"\n");
        int[] arr2 = {7,4,6,5};
        Test009.printArray(arr2);
        System.out.println("是一个二叉查找树的后序序列："+Test009.existCorrespondBSTree(arr2)+"\n");
        int[] arr3 = {7,11,16,20,52,51,50,18};
        Test009.printArray(arr3);
        System.out.println("是一个二叉查找树的后序序列："+Test009.existCorrespondBSTree(arr3));
    }
}