package com.zhangbao.zhangbaoTest.modules.bitMap;
 
import java.util.Random;
 
/**
 * 问题出处：* 给40亿个不重复的unsignedint的整数，没排过序的，
 * 然后再给一个数，如何快速判断这个数是否在那40亿个数当中？
 * @author sd
 *
 */
public class BitMapTest {
    /**
     * 解题思路，用bitmap（位图）的方式节约空间
     * 
     * 
     * int共有32位(留一个符号位)。一个int可以表示 0～31之间的数字。可以申请一个数组，a[0]可以表示0～31
     * a[1] 表示 32～63 以此类推。
     */
     
    /**
     * 将一连串的数字 初始化到 bitmap中
     * @param numArr 给出的数字数组
     * @param bitMap 待初始化的数组
     */
    public static void initBitMap(int[] numArr , int[] bitMap){
        for(int i = 0 ; i < numArr.length ; i++){
            int index = getIndex(numArr[i]);//获取 这个数字存储在bitmap中的索引位置（0～30 存在 a1中）
            int destnum = getMod(numArr[i]);//要存入的数字的存储位置（在 0 ～31之间）
            adjustBitMap(destnum, bitMap, index);
        }
    }
     
     
    /**
     * 算法主要做的工作
     * 
     * 将 0～31之间的数字存入到bitmap中。 最高位符号位置位为0（正数）
     *  一个a[0]数字 用32位可以表示成 0100101010101010……要调整这个数字
     * @param pos 要存入的数字的存储位置（在 0 ～31之间）
     * @param bitMap 
     * @param index 数组索引
     */
    public static void adjustBitMap(int pos , int[] bitMap , int index){
        if(pos <31 && pos > -1){
            int num = BitUtil.setBitByPos(bitMap[index], pos, 1);//将这个数字对应的位置位为1
            bitMap[index] = num;
        }
         
    }
     
    /**
     * 查找着数字是否在bitmap中（查找这个数字对应的位为0还是为1）
     * @param destNum 要查找的数字
     * @param bitMap 已经初始化的bitmap
     * @return
     */
    public static int findNum(int destNum , int[] bitMap){
        /**
         * 查找 destNum在bitMap中存储的位置。如果该位为1 ，则这个数字已经存在，否则不存在
         */
        int index = getIndex(destNum);
                if(index > bitMap.length){
            return 0;
        }
        int pos = getMod(destNum);
        int numpre = bitMap[index];
        int bitset = BitUtil.getBitSet(numpre, pos);
        return bitset;
    }
     
    public int isset(int a,int bit){
//      int i=bit;
        a >>= bit;
        if((a&1)==0)
             return 0;
        return 1;
    }
 
     
    /**
     * 获取 这个数字存储在bitmap中的索引位置（0～30 存在 a1中）
     * @param srcNum
     * @return
     */
    public static int getIndex(int srcNum ){
        return srcNum / 32;
    }
     
    public static int getMod(int srcNum){
        return srcNum % 32;
    }
     
    /**
     * 初始化 要存入bitmap中的数字
     * @param numArr
     */
    public static void initNumArr(int[] numArr){
        int limitNum = numArr.length;
        Random ran = new Random();
        for(int i = 0 ; i < limitNum ; i++){
            numArr[i] = ran.nextInt(limitNum);
        }
    }
     
    public static void main(String[] args){
//      int searchNum = 56;
        int searchNum = 66;
        int[] numArr = {19, 64, 45, 56, 0, 54, 28, 2, 23, 34, 40, 18, 54, 50, 49, 29, 20, 31, 47, 30, 24, 17, 50, 57, 33, 55, 21, 22, 27, 45, 3, 19, 17, 49, 24, 5, 15, 24, 27, 35, 6, 53, 9, 61, 4, 6, 12, 23, 52, 48, 39, 39, 21, 1, 11};
        int map_length = numArr.length % 32==0?numArr.length/32 : numArr.length/32+1;
        int[] bitMap = new int[map_length+1];
        initBitMap(numArr, bitMap);
//      System.out.println(Arrays.toString(bitMap));
        int find = findNum(searchNum, bitMap);
        System.out.println(find);
    }
     
     
}