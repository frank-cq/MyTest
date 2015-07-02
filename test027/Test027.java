package test027;

/**
 * Created by cq on 2015/6/28.
 * 第27题：一个台阶总共有n级，如果一次可以跳1级，也可以跳2级。求总共有多少种跳法。
 */
public class Test027 {
    //此题实质就是求解斐波拉契数列
    public static int getNumOfJumpIteration(int n){
        if (n < 1){
            System.out.println("n不应小于1 !");
            return -1;
        }

        int fibN = n, fibN_1 = 2, fibN_2 = 1;
        for (int i=3; i<=n; i++){
            // f(n) = f(n-1) + f(n-2)
            fibN = fibN_1 + fibN_2;
            fibN_2 = fibN_1;
            fibN_1 = fibN;
        }

        return fibN;
    }
    //递归方法，注意f(2)=2
    public static int getNumOfJumpRecursion(int n){
        if (n < 0){
            return -1;
        }
        if (n == 0 || n == 1 || n == 2){
            return n;
        }

        return getNumOfJumpRecursion(n-1) + getNumOfJumpRecursion(n-2);
    }

    public static void main(String[] args){
        System.out.println("迭代方法：9级台阶共有 "+getNumOfJumpIteration(9)+" 种跳法。");

        System.out.println("递归方法：9级台阶共有 "+getNumOfJumpRecursion(9)+" 种跳法。");
    }
}
