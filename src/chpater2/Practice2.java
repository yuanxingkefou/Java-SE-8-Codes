package chpater2;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 请想办法验证一下，对于获得前5个最长单词的代码，一旦找到第5个最长的单词之后，就不会调用filter方法了。
 *
 * 分析：
 * 根据输出结果，只输出了5个bingo，说明在找到第五个之后，就不会调用filter方法了
 */
public class Practice2 {
    private static List<String> words;
    public static void prepareData() throws Exception
    {
        String contents=new String(Files.readAllBytes(
                Paths.get("Alice.txt")), StandardCharsets.UTF_8);

        words= Arrays.asList(contents.split("[\\P{L}]+"));
    }
    
    public static void main(String[] args) throws Exception
    {
        prepareData();
        words.stream()
                .filter(w->{
                    if(w.length()>12)
                    {
                        System.out.println("bingo");
                        return true;
                    }
                    else
                        return false;
                })
                .limit(5)
                .forEach(System.out::println);
    }
}
