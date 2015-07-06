package test030;

/**
 * Created by cq on 2015/7/4.
 * 第30题：输入一个整数n，从1到n这n个整数的十进制表示中1出现的次数。例如输入12，
 *        从1到12这些整数中包含1的数字有1,1,11和12，1一共出现了5次。
 */
public class Test030 {
    //枚举法
    public static int getNumOfOneEnum(int n){
        int count = 0;
        for (int i=1; i<=n; i++){
            for (int j=i; j>0; j/=10){
                if (j%10 == 1){
                    count++;
                }
            }
        }
        return count;
    }
    //类似于排列组合的方法，将每一位为1时其他位可能的组合相加
    public static int getNumOfOne(int n){
        if (n < 1){
            return 0;
        }
        String tmp = Integer.toString(n);
        int digits = tmp.length(), count = 0, pre = 0, suf = 0, curDigit = 0, tmp1 = 10, tmp2 = 1;
        for (int i=1; i<=digits; i++){
            //当前位之前部分
            pre = n/tmp1;
            //当前位之后部分
            suf = n%tmp2;
            //当前位
            curDigit = n%tmp1/tmp2;

            //当前位之前部分*10^当前位之后部分的位数
            if (curDigit == 0){
                count += pre*tmp2;
            }
            //当前位之前部分*10^当前位之后部分的位数+当前位之后部分+1
            else if (curDigit == 1){
                count += pre*tmp2 +suf+1;
            }
            //(当前位之前部分+1)*10^当前位之后部分的位数
            else {
                count += (pre+1)*tmp2;
            }
            tmp2 = tmp1;
            tmp1 *= 10;
        }
        return count;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println("枚举法运行结果："+getNumOfOneEnum(2016));
        long endTime = System.nanoTime();
        System.out.println("枚举法执行了 "+(endTime-startTime)+" ns");

        startTime = System.nanoTime();
        System.out.println("组合法运行结果："+getNumOfOne(2016));
        endTime = System.nanoTime();
        System.out.println("组合法执行了 "+(endTime-startTime)+" ns");

    }
}
