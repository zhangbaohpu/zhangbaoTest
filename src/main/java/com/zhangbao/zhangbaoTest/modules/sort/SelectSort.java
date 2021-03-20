package com.zhangbao.zhangbaoTest.modules.sort;

/**
 * 选择排序
 * 选择排序是每一次从待排序的数据元素中选出最小的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
 * 选择排序和冒泡排序执行了相同次数的比较：N*（N-1）/2，但是至多只进行了N次交换。
 * @author zhangbao
 * @date 2021/2/19 15:49
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {12,123,43,6,21,7,20};
        display(arr);
        sort(arr);
        display(arr);

    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;//默认第一个元素最小
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(min!=i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            System.out.print("第"+(i+1)+"次排序后的结果为：");
            display(arr);
        }
    }

    public static void display(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
