package com.wangls.cn.leetcode;

import java.util.HashMap;

/**
 * 求2数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * 思路：
 * 借助HashMap,
 * 先循环遍历nums数组，比如拿到第一个值，然后，second=target-nums[1]的到的值，如果在nums数组中，则找到结果
 * 如果是传统思路，那么就需要2层循环。
 * 所以借助hashMap，把second的值，放入hashMap中，key为target-原数组的值，value为nums[i]的索引
 * 每次循环的时候，判断hashMap中，是否有跟second相同的值，有，
 * 则根据HashMap中的key(target-原数组的值)，能够找到当初【target-原数组的值】的索引
 * 那么当前索引和当初【target-原数组的值】的索引对应的值的和=target
 * 所以这2个索引为所求
 * 比如开始
 * nums[0] = 2 index = 0
 * HashMap中的值 (9-2，0)
 * nums[1] = 4 ,index = 1
 * HashMap中的值 (9-2，0),(9-4,1)
 * nums[2] = 7, index=2
 * 而9-2=7，所以nums[2]的值已经在HashMap中了。
 * 所以索引为 0 和 2
 *
 *
 */
public class twoNum1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,7,10};
        int[] tn = twoNum1.twoNum(nums,9);
        for (int t:tn){
            System.out.println(t);
        }

    }

    public static int[] twoNum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i = 0; i<nums.length;i++){
            if (map.containsKey(nums[i])){
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }
            map.put(target - nums[i],i);
        }
        return result;
    }
}
