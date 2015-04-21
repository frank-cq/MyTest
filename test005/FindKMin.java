package test005;

/**
 * Created by cq on 2015/3/30.
 * 第5题：输入n个整数，输出其中最小的K个。（数组）
 *       例如输入1,2,3,4,5,6,7，8 这8个数字，则最小的4个数字为1,2，3,4
 */
public class FindKMin {
    //采用选择排序查找最小的K个元素
    public static void findKMin(int[] arr, int k){
        k = (arr.length > k)?k:arr.length;
        for (int i=0 ; i<k ; i++){
            int iMinIndex = i;
            for (int j=i+1 ; j<arr.length ; j++){
                if (arr[j] < arr[iMinIndex]){
                    iMinIndex = j;
                }
            }
            //将第i小的值交换到数组的位置i
            if (iMinIndex != i){
                arr[i] ^= arr[iMinIndex];
                arr[iMinIndex] ^= arr[i];
                arr[i] ^= arr[iMinIndex];
            }
        }
    }
    //打印数组前K个元素
    public static void printKValue(int[] arr, int k){
        k = (arr.length > k)?k:arr.length;
        for (int i=0 ; i<k ; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args){
        int[] arr = {22,2,12,4,11,6,7,8};
        FindKMin.findKMin(arr,5);
        FindKMin.printKValue(arr,5);
    }
}
