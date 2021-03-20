package com.zhangbao.zhangbaoTest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangbao
 * @date 2021/3/7 11:39
 **/
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            String b = in.nextLine();
            if(a.length() > 100 || b.length() > 500000){
                System.out.println(-1);
            }
            for(int i =0;i <a.length(); i++){
                if(a.charAt(i) < 'a' || a.charAt(i) > 'z'){
                    System.out.println(-1);
                }
            }
            for(int i =0;i <b.length(); i++){
                if(b.charAt(i) < 'a' || b.charAt(i) > 'z'){
                    System.out.println(-1);
                }
            }
            int flag  = 0;
            for(int i =0; i<a.length(); i++){
                int index = b.indexOf(a.charAt(i));
                if(index >= flag ){
                    flag = index;
                    if(i == a.length()-1 ){
                        System.out.println(index);
                    }
                }else{
                    System.out.println(-1);
                    break;
                }

            }
        }
    }
}
