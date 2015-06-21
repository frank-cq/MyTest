package test021;

import common.CommonFunctions;

/**
 * Created by cq on 2015/5/15.
 * 第21题：输入两个整数n和m，从数列 1,2,3,...,n中随意取几个数，使其和等于m。
 *        要求将其中所有的可能组合列出来。
 */
public class Test021 {
    public static void getAllCombinations(int n, int m){
        //据等差数列求和公式，计算m超过n的表达上限
        if (n <= 0 || m <= 0 || m > n*(1+n)>>1){
            System.out.println("输入参数非法或m超出1...n序列的表示范围！");
            return;
        }

        Integer[] combination = new Integer[n];

        recursionProcedure(1,n,m,combination);
    }
    //递归求解，combination的每一个位置对应1~n中的一个数，在组合过程中一个数有两种情况，要么被选中，要么被放弃
    public static void recursionProcedure(int num, int n, int m, Integer[] combination){
        //num大于m，或者num超过了n
        if (num > m || num > n){
            return;
        }
        if (num == m){
            combination[num-1] = num;
            CommonFunctions.printPartArray(combination,num-1);
            return;
        }

        //num被选中
        combination[num-1] = num;
        recursionProcedure(num+1,n,m-num,combination);

        //num被放弃
        combination[num-1] = null;
        recursionProcedure(num+1,n,m,combination);
    }
    public static void main(String[] args){
        getAllCombinations(7,8);
    }
}
