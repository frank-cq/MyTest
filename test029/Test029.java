package test029;

import java.util.Stack;

/**
 * Created by cq on 2015/6/28.
 * 第29题：输入两个整数序列，其中一个序列表示栈的push顺序，判断另一个序列有没有可能是对应的pop顺序。
 *        为了简单起见，我们假设push序列的任意两个整数都是不相等的。比如输入的push序列是 1、2、3、4、5，那么
 *        4、5、3、2、1 就有可能是一个pop序列，因为可以有如下的push和pop序列：push 1, push 2, push 3, push 4,
 *        pop, push 5, pop, pop, pop, pop。这样得到的pop序列就是4,5,3,2,1.但序列4,3,5,1,2就不可能是push序列
 *        1、2、3、4、5的pop序列。
 */
public class Test029 {
    public static boolean isCorrespondPopOrder(int[] pushArr, int[] popArr){
        if (pushArr.length != popArr.length){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, j = 0;
        while (i < popArr.length){
            //入栈
            while (j < pushArr.length){
                stack.push(pushArr[j]);
                j++;
                if (pushArr[j-1] == popArr[i]){
                    break;
                }
            }
            //出栈
            int top = stack.pop();           //获取栈顶元素
            while (i < popArr.length){
                //栈顶元素等于出栈序列当前元素，则继续出栈
                if (top == popArr[i]){
                    i++;
                    if (stack.isEmpty()){    //栈已空，跳出循环
                        break;
                    }
                    top = stack.pop();
                }
                //栈顶元素不等于出栈序列当前元素，恢复栈顶元素
                else {
                    stack.push(top);
                    break;
                }
            }
            //正确情况下，入栈已经完毕，那么出栈也完毕，因为入栈在出栈之前
            if (j == pushArr.length){
                break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        int[] pushArr = {1,2,3,4,5};
        int[] popArr = {4,5,3,2,1};
        int[] popArr2 = {4,3,5,1,2};
        System.out.println("4,5,3,2,1 是 1,2,3,4,5 的一个出栈序列："+isCorrespondPopOrder(pushArr,popArr));
        System.out.println("4,3,5,1,2 是 1,2,3,4,5 的一个出栈序列："+isCorrespondPopOrder(pushArr,popArr2));
    }
}
