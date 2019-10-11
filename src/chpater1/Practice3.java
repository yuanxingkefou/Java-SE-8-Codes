package chpater1;

import java.io.File;
import java.util.Arrays;

/**
 * 使用java.io.File类的list(FilenameFilter)方法，编写一个返回指定目录下，具有指定扩展名的所有文件。
 * 使用Lambda表达式（而不是FilenameFilter）来实现。它会捕获闭合作用域中的哪些变量？
 *
 * 分析：
 * 会捕获闭合作用域中的ext变量
 */
public class Practice3 {
    private static String path="D:/";
    private static String ext="exe";

    public File[] getSubFiles(String path,String ext)
    {
        File source=new File(path);
        File[] result=source.listFiles(file->file.getName().endsWith(ext));
        return result;
    }

    public static void main(String[] args)
    {
        Practice3 test=new Practice3();
        File[] res=test.getSubFiles(path,ext);

        Arrays.stream(res).forEach(System.out::println);
    }
}
