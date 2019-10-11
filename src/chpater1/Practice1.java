package chpater1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Arrays.sort方法中的比较器代码的线程与调用sort的线程是同一个吗？
 *
 * 输出：
 * 调用线程：main
 * 比较器线程：main
 * 比较器线程：main
 * 比较器线程：main
 * 比较器线程：main
 *
 * 是同一个线程。
 *
 */
public class Practice1 {
    public static void main(String[] args)
    {
        String[] str={"aaa","b","cc","d","eeeeeeeeee","fffff"};
        System.out.println("调用线程："+Thread.currentThread().getName());

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("比较器线程："+Thread.currentThread().getName());
                return Integer.compare(o1.length(),o2.length());
            }
        });

        Arrays.sort(str,(first,second)->{
            System.out.println("Lambda中比较器线程："+Thread.currentThread().getName());
            return Integer.compare(first.length(),second.length());
        });
    }
}
