package com.zhangbao.zhangbaoTest.modules.sort;

/**
 * 插入排序（直接插入排序，二分插入排序，链表插入排序，希尔排序）
 * 直接插入排序(Straight Insertion Sort)的基本思想是：把n个待排序的元素看成为一个有序表和一个无序表。
 * 开始时有序表中只包含1个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。
 *
 * 在第一轮排序中，它最多比较一次，第二轮最多比较两次，一次类推，第N轮，最多比较N-1次。因此有 1+2+3+...+N-1 = N*（N-1）/2。
 * 假设在每一轮排序发现插入点时，平均只有全体数据项的一半真的进行了比较，我们除以2得到：N*（N-1）/4。用大O表示法大致需要需要 O(N2) 时间级别。
 * @author zhangbao
 * @date 2021/2/19 16:19
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {12,432,4,65,6,7,17};
        display(arr);
        sort(arr);
        display(arr);
    }

    public static void sort(int[] arr){
        //标记要插入的位置
        int j;
        //默认第一个位置（0）的元素看做是一个有序的，第二个位置开始（n-1）为无序的
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            j = i;
            //新元素依次和有序表的数相比较，如果新元素较小，则向后挪动
            while (j>0 && temp < arr[j-1]){

                arr[j] = arr[j-1];//向后挪动
                j--;
            }
            arr[j] = temp;
            System.out.print("第"+(i)+"次排序后的结果为：");
            display(arr);
        }
    }

    public static void display(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
