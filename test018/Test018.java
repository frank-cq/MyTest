package test018;

/**
 * Created by cq on 2015/4/27.
 * 第18题：n个数字（0,1，...，n-1）形成一个圆圈，从数字0开始，每次从这个圆圈中删除第m个数字
 *        （第一个为当前数字本身，第二个为当前数字的下一个数字）。当一个数字删除后，
 *        从被删除数字的下一个继续删除第m个数字。求出在这个圆圈中剩下的最后一个数字。
 */
public class Test018 {
    public static int deleteMthNum(int[] arr, int m){
        if (arr == null){
            return Integer.MAX_VALUE;
        }

        int fnIndex = 0;
        for (int i = 2; i <= arr.length; i++){
            fnIndex = (fnIndex+m)%i;
        }

        return arr[fnIndex];
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(deleteMthNum(arr,2));
        System.out.println(deleteMthNum(arr,3));
        System.out.println(deleteMthNum(arr,4));
    }
}
