package test028;

/**
 * Created by cq on 2015/6/28.
 * 第28题：输入一个整数，求该整数的二进制表达中有多少个1。例如输入10，
 *        由于其二进制表示为1010，有两个1，因此输出2。
 */
public class Test028 {
    public static int getNumOfOne(int n){
        if (n < 1){
            return -1;
        }

        int count = 0;
        while (n != 0){
            if ((n&1) == 1){
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println("11的二进制表示中有 "+getNumOfOne(11)+" 个1。");
    }
}
