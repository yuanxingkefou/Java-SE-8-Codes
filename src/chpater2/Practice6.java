package chpater2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 构造一个从0开始到s.length()-1的整数流，然后使用s::charAt方法引用来映射它。
 */
public class Practice6 {
    /**
     * 原有实现
     * @param s
     * @return
     */
    public static Stream<Character> characterStream(String s)
    {
        List<Character> result=new ArrayList<>();
        for(char c: s.toCharArray())
        {
            result.add(c);
        }
        return result.stream();
    }

    public static Stream<Character> myCharacterStream(String s)
    {
        return IntStream.range(0,s.length()).mapToObj(s::charAt);
    }
    public static void main(String[] args)
    {
        String str="Hello world";
        Stream<Character> test1=characterStream(str);
        Stream<Character> test2=myCharacterStream(str);

        test1.forEach(System.out::print);
        System.out.println();
        test2.forEach(System.out::print);
    }
}
