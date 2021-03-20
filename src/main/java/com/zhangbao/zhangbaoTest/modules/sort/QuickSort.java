package com.zhangbao.zhangbaoTest.modules.sort;

/**
 * 快速排序流程：
 * (1) 从数列中挑出一个基准值。
 * (2) 将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；在这个分区退出之后，该基准就处于数列的中间位置。
 * (3) 递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序。
 *
 * 快速排序的时间复杂度在最坏情况下是O(N2)，平均的时间复杂度是O(N*lgN)。
 * @author zhangbao
 * @date 2021/2/20 14:06
 **/
public class QuickSort {
    private static int num = 1;
    public static void main(String[] args) {
        int[] arr = {23,4,56,27,19,81,9};
        System.out.println("=====快速排序=====");
        System.out.println("排序前：");
        display(arr);
        sort(arr, 0, arr.length-1);
        System.out.println("排序后：");
        display(arr);
    }

    /**
     * @param arr 待排数组
     * @param l   数组左边界 i=0
     * @param r   数组右边界 j=arr.length-1
     */
    public static void sort(int[] arr, int l, int r){
        if(l < r){
            int i = l;//左指针
            int j = r; //右指针
            int x = arr[i];//要比较的基准值
            while (i < j){//左边指针小于右边指针
                while (i < j && x < arr[j]){
                    j--;//从右向左找小于x的元素下标
                }
                if(i < j){
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < x){
                    i++;//从左向右找第一个大于x的元素下标
                }
                if(i < j){
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            System.out.print("第"+(num++)+"次排序后结果为：");
            display(arr);
            sort(arr, l, i-1);
            sort(arr,i+1, r);
        }
    }
    public static void display(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
