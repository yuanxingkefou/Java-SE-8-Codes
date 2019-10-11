package chpater2;

import java.util.stream.Stream;

/**
 * 使用Stream.iterate()来得到一个包含随机数字的无限流，不允许调用一个Math.random()，只能实现一个
 * 线性同余生成器。在这个生成器中，你可以从x0=seed开始，然后根据合适的a,c,m值生成
 * Xn+1=(a*Xn+c)%m。
 */
public class Practice5 {
    public static void main(String[] args)
    {
        long seed=0;
        long a=25214903917L;
        long c=11;
        long m=1L<<48;
        Stream<Long> nums=Stream.iterate(seed,(x)->(a*x+c)%m);

        nums.limit(10).forEach(System.out::println);
    }
}
