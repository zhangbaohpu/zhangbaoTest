package com.zhangbao.zhangbaoTest.modules;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangbao
 * @date 2021/2/17 11:51
 **/
public class Test {
    public static void main(String[] args) {
        String extStr = "[a-z]";
        String val = "WEDFweds";
        Pattern compile = Pattern.compile(extStr);
        Matcher matcher = compile.matcher(val);
        boolean matches = matcher.matches();
        System.out.println(matches);
    }

}
