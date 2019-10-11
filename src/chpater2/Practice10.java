package chpater2;

import java.util.stream.Stream;

/**
 * 编写一个可以用以计算Stream<Double>平均值的聚合方法。为什么不能直接计算出总和，再除以count()
 *
 * 分析：
 * 因为获得总和和获得count都会导致流的终止
 */
public class Practice10 {
    public static void main(String[] args)
    {
        Stream<Double> doubleStream=Stream.of(1.2,3.4,5.6,4.5);
    }
}
