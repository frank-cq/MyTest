package test002;

/**
 * Created by cq on 2015/3/25.
 * 第二题：定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素
 * 要求：函数min、push以及pop的时间复杂度为O（1）
 */
public class MinStack {
    private Node stack;
    public MinStack(){
        stack = null;
    }
    public boolean isEmpty(){
        return stack == null;
    }
    //返回最小值，不对栈进行操作
    public int getMinData(){
        if (isEmpty()){
            //用int型的最大值表示异常
            return Integer.MAX_VALUE;
        }
        return stack.getMinData();
    }
    public int pop(){
        if (isEmpty()){
            return Integer.MAX_VALUE;
        }

        int temp = stack.getData();
        stack = stack.getNext();
        return temp;
    }
    public void push(int data){
        Node node = new Node(data);
        if (!isEmpty()){
            if (node.getMinData() > stack.getMinData()){
                node.setMinData(stack.getMinData());
            }
            node.setNext(stack);
        }
        stack = node;
    }
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(5);
        System.out.println(minStack.getMinData());
        minStack.push(9);
        System.out.println(minStack.getMinData());
        minStack.push(4);
        System.out.println(minStack.getMinData());
        minStack.push(3);
        System.out.println(minStack.getMinData());
        minStack.push(1);
        System.out.println(minStack.getMinData());
        minStack.pop();
        System.out.println(minStack.getMinData());
        minStack.pop();
        System.out.println(minStack.getMinData());
        minStack.pop();
        System.out.println(minStack.getMinData());
    }
}

