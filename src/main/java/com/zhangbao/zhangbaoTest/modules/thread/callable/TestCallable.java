package com.zhangbao.zhangbaoTest.modules.thread.callable;

import com.zhangbao.zhangbaoTest.modules.thread.TestLoadImage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 创建有返回值的线程
 * @author zhangbao
 * @date 2020/12/27 12:54
 **/
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url,String name){
        this.url = url;
        this.name = name;
    }
    @Override
    public Boolean call() throws Exception {
        WebDownLoader downLoader = new WebDownLoader();
        downLoader.downLoader(url,name);
        System.out.println("下载文件完成，"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable image1 = new TestCallable("https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/0b46f21fbe096b636678ddd40c338744eaf8acd5.jpg","image1.jpg");
        TestCallable image2 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201307%2F05%2F083016g5mzgmygmd100qg7.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1611632731&t=e2dbd6d3f76e043dc295aa5dc5b0cb4d","image2.jpg");
        TestCallable image3 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Ffiles.vivo.com.cn%2Fvivobbs%2Fdata%2Fattachment%2Fforum%2F201601%2F06%2F113530v72cp7ghsa2h2t7t.jpg&refer=http%3A%2F%2Ffiles.vivo.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1611632731&t=3ce7fae229651ad7dea21319c8bd8c2a","image3.jpg");

        //创建线程池
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> future1 = ser.submit(image1);
        Future<Boolean> future2 = ser.submit(image2);
        Future<Boolean> future3 = ser.submit(image3);

        //获取结果
        Boolean b1 = future1.get();
        Boolean b2 = future2.get();
        Boolean b3 = future3.get();

        //关闭服务
        ser.shutdown();
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