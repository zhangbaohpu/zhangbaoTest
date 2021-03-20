package com.zhangbao.zhangbaoTest.modules.sort;

/**
 * 希尔排序
 * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序
 * @author zhangbao
 * @date 2021/2/19 17:11
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {23,2,45,26,  19,13,40,72};
        display(arr);
        sort(arr);
        display(arr);
    }
    public static void sort(int[] arr){
        int len = arr.length;
        int gap = len/2;
        while (gap>0){
            for (int i = gap; i < len; i++) {
                int temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp){
                    arr[preIndex + gap] = arr[preIndex];//向后挪动
                    preIndex = preIndex - gap;
                }
                arr[preIndex + gap] = temp;
            }
            //增量排序
            System.out.print("增量"+gap+"排序后的结果：");
            display(arr);
            gap /=2;
        }
    }

    public static void display(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
