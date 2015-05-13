package test019;

/**
 * Created by cq on 2015/4/29.
 * 第19题（数组、递归）：定义Fibonacci数列如下：f(0)=0,f(1)=1,f(n)=f(n-1)+f(n-2)。输入n，用最快的方法求该数列的第n项。
 */
public class Test019 {
    //一般递归方法，有重复计算
    public static int sumFibRecursion(int n){
        if (n == 0 || n == 1){
            return n;
        }

        return sumFibRecursion(n-1) + sumFibRecursion(n-2);
    }

    //迭代方法
    public static int sumFibIteration(int n){
        if (n < 0){
            System.out.println("n不应小于0!");
            return -1;
        }

        int fibN = n, fibN_1 = 1, fibN_2 = 0;
        for (int i=2; i<=n; i++){
            // f(n) = f(n-1) + f(n-2)
            fibN = fibN_1 + fibN_2;
            fibN_2 = fibN_1;
            fibN_1 = fibN;
        }

        return fibN;

//        int[] arr = {0,1};
//        for (int i=2; i<=n; i++){
//            if (i&1 == 0){
//                arr[0] = arr[0] + arr[1];
//            }
//            else {
//                arr[1] = arr[0] + arr[1];
//            }
//        }
//        return arr[n&2];
    }

    //矩阵递归方法，无重复计算，根据计算公式：（f(n),f(n-1))^T = A^(n-1) * (1,0)^T
    public static int sumFibMatrix(int n){
        if (n < 0){
            return -1;
        }
        int[] matrix = {1,1,1,0};
        matrixPower(matrix,n-1);
        return matrix[0];
    }
    //分治法求矩阵的n次幂（效率就在这儿）
    public static void matrixPower(int[] matrix, int n){
        if (matrix == null || matrix.length != 4 || n <0){
            return;
        }
        if (n == 0){
            matrix[0] = matrix[1] = matrix[2] = matrix[3] = 1;
            return;
        }
        else if (n == 1){
            matrix[0] = matrix[1] = matrix[2] = 1;
            matrix[3] = 0;
            return;
        }
        //偶次幂，A^n = A^(n/2) * A^(n/2)
        if ((n&1) == 0){
            matrixPower(matrix,n/2);
            calculateMatrix(matrix,matrix,matrix);
        }
        //奇次幂,A^n = A^((n-1)/2) * A^((n-1)/2) * A
        else {
            matrixPower(matrix,(n-1)/2);
            calculateMatrix(matrix,matrix,matrix);
            calculateMatrix(matrix,new int[]{1,1,1,0},matrix);
        }

    }
    //二阶矩阵相乘（二阶矩阵映射到一维数组上）
    public static void calculateMatrix(int[] matrixA, int[] matrixB, int[] matrix){
        if (matrixA == null || matrixA.length != 4 ||
                matrixB == null || matrixB.length != 4){
            return;
        }
        int value00 = matrixA[0]*matrixB[0] + matrixA[1]*matrixB[2];
        int value01 = matrixA[0]*matrixB[1] + matrixA[1]*matrixB[3];
        int value10 = matrixA[2]*matrixB[0] + matrixA[3]*matrixB[2];
        int value11 = matrixA[2]*matrixB[1] + matrixA[3]*matrixB[3];
        matrix[0] = value00;
        matrix[1] = value01;
        matrix[2] = value10;
        matrix[3] = value11;
    }

    public static void main(String[] args){

        System.out.println("使用递归求解斐波拉契数列结果："+sumFibRecursion(10));

        System.out.println("使用迭代求解斐波拉契数列结果："+sumFibIteration(10));

        System.out.println("使用矩阵求解斐波拉契数列结果："+sumFibMatrix(10));
    }
}
