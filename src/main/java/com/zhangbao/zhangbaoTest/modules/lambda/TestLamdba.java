package com.zhangbao.zhangbaoTest.modules.lambda;

/**
 * 推导lambda
 * @author zhangbao
 * @date 2020/12/27 13:59
 **/
public class TestLamdba {
    //3 静态内部类
    static class FuncInter2 implements IFuncInter{
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        //使用实现类
        IFuncInter inter = new FuncInter();
        inter.lambda();

        //使用静态内部类
        inter = new FuncInter2();
        inter.lambda();

        //4 局部内部类
        class FuncInter3 implements IFuncInter{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        inter = new FuncInter3();
        inter.lambda();

        //5 匿名内部类，没有类名称，借助接口或父类
        inter = new IFuncInter() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        inter.lambda();

        //6 lambda表达式
        inter = ()->{
            System.out.println("I like lambda5");
        };
        inter.lambda();

    }

}
//1 定义一个函数式接口
interface IFuncInter{
    void lambda();
}

//2 实现类
class FuncInter implements IFuncInter{
    @Override
    public void lambda() {
        System.out.println("I like lambda1");
    }
}