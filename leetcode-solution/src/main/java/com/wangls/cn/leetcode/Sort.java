package com.wangls.cn.leetcode;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        int[] arrayv3 = new int[]{3,4,2,1,5,6,7,8};
        sortv1(array);
        sortv3(arrayv3);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayv3));

    }

    /**
     * 冒泡排序
     * 基本原理，相邻的2个元素依次做比较，如果大的做左边，2个元素就交换位置，以此类推
     * 第一层循环只是为了比较n-1轮
     * 第二层循环是每一轮比较的次数，一共比较C(n-1)次
     *
     * @param array
     */
    public static void sortv1(int array[]){
        for(int i = 0;i<array.length-1 ;i++){
            for (int j = 0;j<array.length-i-1;j++){
                int one = array[j];
                int two = array[j+1];
                int tmp;
                if (one > two){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 优化：当数列其实已经有序，但是v1版还是会继续执行，所以v2增加一个有序判断
     * @param array
     */
    public static void sortv2(int array[]){

        for(int i = 0;i<array.length-1 ;i++){
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0;j<array.length-i-1;j++){
                int one = array[j];
                int two = array[j+1];
                int tmp;
                if (one > two){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    //因为有元素进行交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            //跳槽大循环
            if (isSorted){
                break;
            }
        }
    }

    /**
     * 初始数据[3,4,2,1,5,6,7,8]
     * 优化：关键在于数据有序区的界定
     *      按照正常的逻辑，有序区的长度和排序的轮数是相等的。
     *      但实际情况，有序区可能比正常逻辑的要大，
     *      所以我们可以在每一轮排序后，记录下来最后一次元素交换的位置，
     *      该位置即为无序数列的边界，再往后就是有序区了
     * @param array
     */
    public static void sortv3(int array[]){
        int index = 0;
        for (int i=0;i<array.length-index-1;i++){
            System.out.println("比较轮次:"+i);
            boolean isSorted = true;
            for(int j = 0;j<array.length-i-1;j++){
                int tmp;
                if (array[j]>array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted = false;
                    index = j;
                }
            }
            if (isSorted){
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序
     * @param array
     */
    public static void sortv4(int array[]){

    }
}
