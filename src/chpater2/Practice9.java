package chpater2;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * 将一个Stream<ArrayList<T>>中的全部元素连接为一个ArrayList<T>。试着采用三种不同形式的聚合方法来实现
 */
public class Practice9 {
    public static <T> ArrayList<T> method1(Stream<ArrayList<T>> arrayListStream)
    {
        return arrayListStream.reduce((a1,a2)->{
            a1.addAll(a2);
            return a1;
        }).orElse(new ArrayList<T>());
    }

    public static <T> ArrayList<T> method2(Stream<ArrayList<T>> arrayListStream)
    {
        return arrayListStream.reduce(new ArrayList<T>(),(a1,a2)->{
            a1.addAll(a2);
            return a1;
        });
    }

    public static <T> ArrayList<T> method3(Stream<ArrayList<T>> arrayListStream)
    {
        return arrayListStream.reduce(new ArrayList<T>(),
                (result,added)->
                {
                    result.addAll(added);
                    return result;
                }
                ,(result1,result2)->
                {
                    result1.addAll(result2);
                    return result1;
                });
    }

    public static Stream<ArrayList<Integer>> initStream() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0, 2);
        list1.add(1, 3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0, 4);

        return Stream.of(list1, list2);
    }
    
    public static void main(String[] args)
    {
        method1(initStream()).forEach(System.out::print);
        System.out.println();
        method2(initStream()).forEach(System.out::print);
        System.out.println();
        method3(initStream()).forEach(System.out::print);
    }
}
