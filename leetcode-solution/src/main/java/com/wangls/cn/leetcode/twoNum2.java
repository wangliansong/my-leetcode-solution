package com.wangls.cn.leetcode;

/**
 * 有序数组
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 *
 * 思路：
 * 使用双指针
 */
public class twoNum2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,7,10};
        int[] tn = twoNum2.twoNum(nums,9);
        for (int t:tn){
            System.out.println(t);
        }
    }

    private static int[] twoNum(int[] numbers,int target){
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while(left<right){
            if ((numbers[left] + numbers[right]) == target){
                result[0] = left+1;
                result[1] = right+1;
                break;
            }else if ((numbers[left] + numbers[right]) < target){
                left ++;
            }else {
                right --;
            }
        }
        return result;
    }

}
