package com.wangls.cn.leetcode;

import java.util.Arrays;

/**
 * 计数排序：线性排序时间，近似O(n)
 *
 * 1、得到数列的最大值，用来确定统计数组的长度
 * 2、遍历原数组，每一个元素按照其值，对号入座，即放到统计数组对应的下标位置，array[i]的值=countArray(统计数组)的j(下标)
 *      并且countArray[j]的值+1，代表这个值在原数组中出现的次数
 * 3.遍历统计数组，输出结果，详情见下文
 *
 * 优化：
 * 1、直接以原数组的最大值+1，作为统计数组的长度，不太严谨，可以使用最大值-最小值+1来代替
 *
 * 适用条件：
 * 1、当数组的最大和最小值差距过大时，不适用计数排序
 * 2、当数组的元素不是整数时，不适合用计数排序
 */
public class CountSort {

    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
        int[] sortArray = countSort(array);
        System.out.println(Arrays.toString(sortArray));

    }

    public static int[] countSort(int[] array){
        //1.得到数列的最大值
        int max = array[0];
        for(int i=1;i<array.length;i++){
            if (array[i] >= max){
                max = array[i];
            }
        }
        //2.根据数组的最大值确定统计数组的长度
        int[] countArray = new int[max+1];
        //3.遍历数组，填充统计数组
        for(int i = 0;i<array.length;i++){
            //countArray[array[i]] = countArray[array[i]] + 1;
            countArray[array[i]] ++;
        }
        //4.遍历统计数组，输出结果
        int index = 0;
        int[] sortArray = new int[array.length];
        for(int i = 0;i<countArray.length;i++){
            // countArray[i]，即countArray下标对应的值，是几说明在原数组中，
            //有几个等于下标的值，比如下标i=3，countArray[i]=2,说明，原数组中值是3的元素有2个。
            for(int j = 0;j<countArray[i];j++){
                //i，即对应的原数组的值，所以把他赋值给sortArray。
                sortArray[index++] = i;
            }
        }
        return sortArray;
    }
}
