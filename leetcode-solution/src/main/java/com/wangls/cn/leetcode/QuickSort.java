package com.wangls.cn.leetcode;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int startIndex,int endIndex){
        //递归结束条件，startIndex大于或者等于endIndex
        if (startIndex >= endIndex){
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition(arr,startIndex,endIndex);
        quickSort(arr,startIndex,pivotIndex-1);
        quickSort(arr,pivotIndex+1,endIndex);
    }
    /**
     * 快速排序(双边循环法)
     * 1、选定基准元素pivot，并设置两个指针left和right，指向数列的最左和最右两个元素
     * 2、进行第一次循环，从right开始，让指针指向的元素arr[right]和基准pivot做比较，
     *      如果大于或者等于arr[right]>=pivot ，则指针左移动，小于pivot，则right指针停止移动，切换到left指针
     * 3、轮到left指针移动了，让left指向指向的元素和基准做比较，
     *      如果小于或者等于pivot，则右移动left指针，大于pivot，则left指针停止移动
     * 4、让left和right指针所指向的元素进行交换
     * 5、循环执行1-4步骤，直到left和right指针重合，停止循环
     * 6、把pivot元素和5步骤的元素位置交换(left和right指针重合的位置),至此本轮结束
     *
     * 这只是一轮排序，利用递归，执行剩下的轮次看上面的quickSort方法
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] arr,int startIndex,int endIndex){
        //取第一个位置的元素为基准位置(也可以随机取)，也就是基准元素pivot和left重合
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right){
            //控制移动right指针
            while (left < right && arr[right] >= pivot){
                right--;
            }
            //控制移动left指针
            while (left < right && arr[left] <= pivot){
                left++;
            }
            //交换left和right指针所指向的元素
            if (left < right){
                int tmp;
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }

        }
        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }
}
