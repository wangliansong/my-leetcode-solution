package com.wangls.cn.leetcode;

import sun.jvm.hotspot.utilities.BitMap;

import java.util.*;

/**
 * 最长正数序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 */
public class zuichangzhengshuxunlie {

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int longestConsecutive = longestConsecutive(nums);
        System.out.println(longestConsecutive);
    }

    public static int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        if(nums.length<1) return 0;
        if(nums.length<2) return 1;
        int longest = 1;
        int tmp = 1;
        for (int i=0;i<nums.length-1;i++){
            int cha = nums[i+1] - nums[i];
            if(cha == 1){
                tmp ++;
            }
            else if (cha >1 ){
                tmp = 1;
            }
            if (longest<tmp) longest= tmp;
        }
        return longest;
    }
}

