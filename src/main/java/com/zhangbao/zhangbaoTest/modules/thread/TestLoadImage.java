package com.zhangbao.zhangbaoTest.modules.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 创建线程：继承Thread线程，重写run方法
 * @author zhangbao
 * @date 2020/12/27 11:33
 **/
public class TestLoadImage extends Thread {
    private String url;
    private String name;

    public TestLoadImage(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader downLoader = new WebDownLoader();
        downLoader.downLoader(url,name);
        System.out.println("下载文件完成，"+name);
    }

    public static void main(String[] args) {
        TestLoadImage image1 = new TestLoadImage("https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/0b46f21fbe096b636678ddd40c338744eaf8acd5.jpg","image1.jpg");
        TestLoadImage image2 = new TestLoadImage("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201307%2F05%2F083016g5mzgmygmd100qg7.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1611632731&t=e2dbd6d3f76e043dc295aa5dc5b0cb4d","image2.jpg");
        TestLoadImage image3 = new TestLoadImage("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Ffiles.vivo.com.cn%2Fvivobbs%2Fdata%2Fattachment%2Fforum%2F201601%2F06%2F113530v72cp7ghsa2h2t7t.jpg&refer=http%3A%2F%2Ffiles.vivo.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1611632731&t=3ce7fae229651ad7dea21319c8bd8c2a","image3.jpg");

        image1.start();
        image2.start();
        image3.start();
    }

}

//下载器
class WebDownLoader{
    public void downLoader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downLoader方法异常");
        }
    }
}
