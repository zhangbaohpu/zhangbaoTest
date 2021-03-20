package com.zhangbao.zhangbaoTest.modules.sort;

/**
 * 冒泡排序
 * N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数
 * 冒泡排序最好的时间复杂度为O(n)。最坏的时间复杂度为：O(n2)
 * @author zhangbao
 * @date 2021/2/19 15:12
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {12,22,3,45,27,2,19};
        display(arr);
        sort(arr);
        display(arr);
    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
            System.out.print("第"+(i+1)+"轮排序后的结果为：");
            display(arr);

        }
    }

    public static void  display(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
