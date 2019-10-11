package chpater2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 假设你有一个数组int[] values={1,4,9,16}。那么Stream.of(values)的结果是什么？你如何获得一个int类型
 * 的流
 *
 * 分析：
 * Stream.of(values)的结果是一个Stream<T>
 * 可以使用IntStream.of()来获得一个int类型的流，可以避免装箱拆箱的消耗
 */
public class Practice4 {
    public static void main(String[] args)
    {
        int[] values={1,4,9,16};
        Stream.of(values);

        IntStream.of(values).forEach(System.out::println);
    }
}
