package test014;

/**
 * Created by cq on 2015/4/16.
 * 第14题：输入一个已经按升序排序过的数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。
 * 要求：  时间复杂度是O（n）。如果有多对数字的和等于输入的数字，输出任意一对即可。
 * 例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 */
public class Test014 {
    public static String getPair(int[] arr, int k){
        if (arr == null || arr[0] >= k){
            return null;
        }

        int head = 0, tail = arr.length-1;

        //如果尾上的值比k大，则尾指针前移，直到到达一个比k小的值
        while (head < tail && arr[tail] >= k){
            tail--;
        }

        //从数组的两头向中间扫描，最差情况下整个数组被扫描一遍
        while (head < tail){
            if (arr[head] + arr[tail] == k){
                return arr[head]+" "+arr[tail];
            }
            else if (arr[head] + arr[tail] > k){
                tail--;
                continue;
            }
            else
                head++;
        }

        return null;
    }
    public static void main(String[] args){
        int[] arr = {1,2,4,7,11,15};
        System.out.println("数组中和为15的两数为："+getPair(arr,15));
        System.out.println("数组中和为15的两数为："+getPair(arr,19));
        System.out.println("数组中和为15的两数为："+getPair(arr,21));
    }
}
