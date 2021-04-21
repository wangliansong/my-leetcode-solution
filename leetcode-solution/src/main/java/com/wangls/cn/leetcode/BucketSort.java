package com.wangls.cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序 时间复杂度O(n)，极端情况下(第一个桶有n-1个元素)退化成O(nlogn)
 * 1.创建桶，并确定每一个桶的区间范围
 *      创建多少个桶，每个桶的区间范围是多少，方法很多
 *      我们这里是桶的个数等于原属数组中的元素个数
 *      除最后一个桶只包含数组的最大值外，前面各个桶的区间按照比例来确定：区间跨度=(最大值-最小值) /(桶的数量-1)
 * 2.遍历原始数组，把元素对号入座放入各个桶中
 * 3.对每个桶内部的元素分别进行排序
 * 4.遍历所有的桶，输出所有元素
 *
 *
 * 总结：
 * 排序算法  平均时间复杂度  最坏时间复杂度  空间复杂度  是否稳定排序
 * 冒泡排序     O(n2)       O(n2)       O(1)        是
 * 鸡尾酒排序    O(n2)       O(n2)       O(1)        是
 * 快速排序     O(nlogn)    O(n2)       O(logn)     不是
 * 堆排序      O(nlogn)     O(nlogn)   O(1)        不是
 * 计数排序     O(n+m)      O(n+m)      O(m)        是
 * 桶排序      O(n)        O(nlogn)    O(n)        是
 */
public class BucketSort {
    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] sortArray = bucketSort(array);
        System.out.println(Arrays.toString(sortArray));
    }

    public static double[] bucketSort(double[] array){
        //1.得到数组的最大值和最小值，并计算差值
        double max = array[0];
        double min = array[0];
        for (int i = 1;i<array.length;i++){
            if (max < array[i]){
                max = array[i];
            }
            if (min > array[i]){
                min = array[i];
            }
        }
        double d = max - min;
        //2.初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0;i<bucketNum;i++){
            bucketList.add(new LinkedList<Double>());

        }
        //3.遍历原始数组，将每个元素放入桶中
        for (int i = 0;i<array.length;i++){
            int num = (int)((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }
        //4.对每个桶进行内部排序
        for (int i = 0;i<bucketList.size();i++){
            Collections.sort(bucketList.get(i));
        }
        //5.输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list:bucketList){
            for (double element:list){
                sortedArray[index++] = element;
            }
        }
        return sortedArray;
    }
}
