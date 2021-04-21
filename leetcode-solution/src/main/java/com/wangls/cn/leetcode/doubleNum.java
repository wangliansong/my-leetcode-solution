package com.wangls.cn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 找出数组中重复的数字
 * 在一个长度n的数组nums里的所有数字都在0～n-1的范围内，数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次，
 * 请找出数字中任意一个重复的数字。
 * 思路：利用set集合，set本身是不允许重复的，所以遇到的set集合里面有的那个值就是重复的
 *
 */
public class doubleNum {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4,4,3};
        int a = findRepeatNumber(num);
        System.out.println(a);

        String a1 = "11dfsq131fdfdf";
        System.out.println(DigestUtils.md2Hex(a1));
        System.out.println(a1);
    }
    public static int findRepeatNumber(int[] nums){
        Set<Integer> set = new HashSet<>();
        int m = 0;
        for (int n :nums){
            if (set.contains(n)){
                m = n;
                return m;
            }
            else{
                set.add(n);
            }

        }
        return m;

    }
    //两数之和
    public int[] twoSum(int[] nums,int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
          if (map.containsKey(nums[i])){
              result[0] = i;
              result[1] = map.get(nums[i]);
              return result;
          }
          map.put(target-nums[i],i);
        }
        return result;
    }
}
