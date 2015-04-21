package test003;

/**
 * Created by cq on 2015/3/26.
 * 第三题：输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个正数组成一个子数组，
 *        每个子数组都有一个和。求所有子数组的和的最大值。
 * 要求：时间复杂度为O（n）
 */
public class SumOfMaxSubArr {
    public static int sumOfMaxSA(int[] arr){
        if (arr.length == 0){
            return -1;
        }
        int max = arr[0],sum = arr[0];
        for (int i=1;i < arr.length;i++){
            sum = (sum + arr[i] > 0) ? (sum + arr[i]) : 0;
            max = (sum > max) ? sum : max;
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println("最大子数组的和为："+SumOfMaxSubArr.sumOfMaxSA(arr));
    }
}
