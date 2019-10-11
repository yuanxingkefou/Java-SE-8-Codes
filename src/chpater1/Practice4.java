package chpater1;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 对于一个指定的File对象数组，首先按照路径的目录排序，然后对每组目录中的元素再按照路径名排序。
 * 请使用Lambda表达式来实现
 */
public class Practice4 {

    public static void main(String[] args)
    {
        File[] files = new File[5];
        files[0] = new File("C:\\Windows\\addins\\FXSEXT.ecf");
        files[1] = new File("C:\\Windows\\Cnxt\\setup5776297E157xyz\\FXSEXT.ecf");
        files[2] = new File("C:\\Windows\\AppPatch\\pcamain.sdb");
        files[3] = new File("C:\\Windows\\Cnxt\\setup5776297E157xyz\\DtsHpxInit64.dll");
        files[4] = new File("C:\\Windows\\AppPatch\\frxmain.sdb");

        Arrays.sort(files,((f1,f2)->
                f1.getParent().equals(f2.getParent())
                        ?f1.getAbsolutePath().compareTo(f2.getAbsolutePath())
                        :f1.getParent().compareTo(f2.getParent())));

        Arrays.stream(files).forEach(System.out::println);
    }
}
