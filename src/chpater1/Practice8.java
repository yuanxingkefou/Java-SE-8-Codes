package chpater1;

import java.util.ArrayList;
import java.util.List;

/**
 * 当一个Lambda表达式捕获了如下增强for循环中的值时，会发生什么？
 *
 * 输出：
 * Peter
 * Mary
 * Paul
 */
public class Practice8 {

    public static void main(String[] args)
    {
        String[] names={"Peter","Paul","Mary"};
        List<Runnable> runners=new ArrayList<>();

        //题目中的增强for循环
        for(String name:names)
        {
            runners.add(()->System.out.println(name));
        }
        /*
        原始循环中i的值会发生变化，不是事实上的final，Lambda表达式只能捕获不变的值，所以运行会出错
        for(int i=0;i<names.length;i++)
        {
            runners.add(()->System.out.println(names[i]));
        }
        */
        runners.stream().map(Thread::new).forEach(Thread::start);
    }
}
