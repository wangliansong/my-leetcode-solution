package com.wangls.cn.leetcode;

import java.util.*;

/**
 * 3个数求和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 *
 * 思路：
 * 排序+双指针
 */
public class threeNumSum {
    public static void main(String[] args) {
        //int[] nums = new int[]{-1,0,1,2,-1,-4};
        //[-2,0,1,1,2]
        int[] nums = new int[]{-2,0,1,1,2};
        List<List<Integer>> rs = threeNumSum(nums);
        for (List r:rs){
            System.out.println(r.toString());
        }
    }

    private static List<List<Integer>> threeNumSum2(int[] nums){
        List<List<Integer>> lists = new ArrayList();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }
    private static List<List<Integer>> threeNumSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> arrayList = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            if (i>0 && (nums[i] == nums[i-1])) continue;
            twoNum(nums,i,-nums[i],arrayList);

        }
        return arrayList;
    }

    private static List<List<Integer>> twoNum(int[] nums,int index,int target,List<List<Integer>> result){
        int left = index+1;
        int right = nums.length - 1;
        while(left<right){
            if ((nums[left] + nums[right]) == target){
                result.add(Arrays.asList(nums[index],nums[left],nums[right]));
                while (left < right && nums[left] == nums[left+1]) ++left;
                while (left < right && nums[right] == nums[right-1]) --right;
                ++left;
                --right;
            }else if ((nums[left] + nums[right]) < target){
                ++left;
            }else {
                --right;
            }
        }
        return result;
    }
}
