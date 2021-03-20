package com.zhangbao.zhangbaoTest.modules.bitMap;
 
public class BitUtil {
 
    /**
     * 将一个数字的某一位置位为 0 或者置位为1
     * @param numpre 
     * @param pos 0~31
     * @param setnum 0或者1
     * @return 置位后的数字
     */
    public static int setBitByPos(int numpre , int pos , int setnum){
        if(setnum == 1 ){
            numpre |= (1<<pos);
        }else{
            numpre &= ~(1 << pos);
        }
        return numpre;
    }
     
    /**
     * 获取某一位的二进制
     * @param num
     * @param pos 0~31
     * @return
     */
    public static int getBitSet(int num,int pos){
        num >>= pos;
        if((num&1)==0){
              return 0;
        }
        return 1;
    }
 
    public static void main(String[] args){
        int numpre = 0;
        int pos = 31;
        int setnum = 1;
        int num = setBitByPos(numpre, pos, setnum);
        System.out.println(Integer.toBinaryString(num));
//      int num = getBitSet(numpre  , pos);
        System.out.println(num);
    }
     
}