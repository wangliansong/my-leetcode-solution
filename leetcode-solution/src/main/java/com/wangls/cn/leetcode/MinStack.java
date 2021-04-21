package com.wangls.cn.leetcode;

import java.util.Stack;

/**
 * 最小栈问题
 * 1、设原有的栈叫做栈A，此时创建一个额外的备胎栈，栈B，用来辅助栈A
 * 2、当第1个元素进入栈A时，让新元素也进入栈B，这个唯一的元素是栈A的当前最小值
 * 3、之后，每当新元素进入栈A时，比较新元素和栈A当前最小值的大小(也即是栈B的栈顶元素),
 *      如果小于栈A当前最小值，则让新元素进入栈B，此时栈B的栈顶元素就是栈A当前的最小值
 * 4、每当栈A有元素出栈时，比较出栈元素和辅助栈B的栈顶元素的大小，如果出栈元素比栈B的栈顶元素小，则栈B栈顶元素也出栈
 *      此时栈B余下的栈顶元素所指向的，就是栈A当中原本第二小的元素，代替刚才的出栈元素成为栈A的当前最小值
 * 5、当调用getMin方法时，返回栈B的栈顶元素，也就是栈A的最小值
 */
public class MinStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) throws Exception{
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());

    }

    /**
     * 入栈操作
     * @param element
     */
    public void push (int element){
        mainStack.push(element);
        //如果辅助栈为空，或者新元素小于或等于辅助栈栈顶，则将新元素压入辅助栈
        if (minStack.isEmpty() || element <= minStack.peek()){
            minStack.push(element);
        }

    }

    /**
     * 出栈
     * @return
     */
    public Integer pop(){
        //如果出栈元素和辅助栈斩顶元素相等，辅助栈出栈
        if (mainStack.pop().equals(minStack.peek())){
            minStack.pop();
        }

        return mainStack.pop();
    }

    /**
     * 获取栈的最小元素
     * @return
     */
    public int getMin() throws Exception{
        if (minStack.isEmpty()){
            throw new Exception("stack is empty");
        }
        //返回辅助栈，栈顶元素
        return minStack.peek();
    }

}
