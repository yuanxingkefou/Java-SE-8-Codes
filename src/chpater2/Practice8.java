package chpater2;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 编写一个方法,一次交替获取流first和second中元素的位置，直到其中一个流结束
 * <p>
 * 分析：
 * 主要考虑流是无限流，所以不能将流存储到容器中，而是采用迭代器来迭代读取
 */
public class Practice8 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        Iterator<T> iterator = new Iterator<T>() {
            private boolean first = false;

            @Override
            public boolean hasNext() {
                first = !first;
                return first ? firstIterator.hasNext() : secondIterator.hasNext();
            }

            @Override
            public T next() {
                return first ? firstIterator.next() : secondIterator.next();
            }
        };
        Iterable<T> iterable = () -> iterator;
        boolean parallel = first.isParallel() || second.isParallel();
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }

    public static void main(String[] args) {
        //两个有限流
        Stream<Integer> stream1 = zip(Stream.of(1, 3, 5), Stream.of(2, 4, 6, 8, 10));
        stream1.forEach(x -> System.out.print(String.format("%d ", x)));
        System.out.println();

        //一个无限流，一个有限流
        Stream<Integer> stream2 = zip(Stream.iterate(1, x -> x * 2), Stream.of(2, 4, 6, 8, 10));
        stream2.forEach(x -> System.out.print(String.format("%d ", x)));
        System.out.println();

        //两个无限流
        Stream<Integer> stream3 = zip(Stream.iterate(1, x -> x * 2), Stream.iterate(1, x -> x * 3)).limit(10);
        stream3.forEach(x -> System.out.print(String.format("%d ", x)));
        System.out.println();
    }
}
