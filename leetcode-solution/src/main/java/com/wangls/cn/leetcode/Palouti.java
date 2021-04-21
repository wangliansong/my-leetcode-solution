package com.wangls.cn.leetcode;

import java.util.HashMap;

/**
 * 爬楼梯
 * 1、递归，复杂度较高，leetcode会超时,所以要改造一下，
 * 递归操作，会有很多重复计算，所以把已经计算的值放到散列表，
 * f(n) = f(n-1)+f(n-2)
 * f(1)= 1
 * f(2) = 1
 *
 *
 */
public class Palouti {
    public static void main(String[] args) {
        int step = palouti(45);
        System.out.println(step);

    }

    private static int palouti(int n){
        int result = -1;
        if (n==1){
            result = 1;
            return result;
        }
        if(n==2){
            result =2;
            return result;
        }
        if(n>2){
            result = palouti(n-1) + palouti(n-2);
            return result;
        }
        return result;
    }

    /**
     *
     * 把重复值放入散列表中，这样重复的值就会很少
     * 这也是解决递归的时候重复的值太对的一个比较好的方法
     */
    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {

        int result = -1;
        if (n==1){
            result = 1;
        }
        if(n==2){
            result =2;
        }
        if(n>2){
            if(map.containsKey(n)){
                return result = map.get(n);
            }
            result = climbStairs(n-1) + climbStairs(n-2);
        }
        map.put(n,result);
        return result;
    }
}
