package chpater1;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * 使用java.io.File类的listFiles(FileFilter)和isDirectory方法，编写一个返回指定目录下所有子目录
 * 的方法。使用Lambda表达式来代替FileFilter对象，再将它改写为一个方法引用。
 *
 */
public class Practice2 {
    private String path="D:/";

    /**
     * 原先实现
     * @return
     */
    public File[] getAllSubFiles(String path)
    {
        File source=new File(path);

        File[] result=source.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if(file.isDirectory())
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        });
        return result;
    }

    /**
     * 使用Lambda表达式
     */
    public File[] getAllSubFilesByLambda(String path)
    {
        File source= new File(path);

        File[] result=source.listFiles(file->file.isDirectory());

        return result;
    }

    /**
     * 使用方法引用
     */
    public File[] getAllSubFilesByFunction(String path)
    {
        File source=new File(path);
        File[] result=source.listFiles(File::isDirectory);
        return result;
    }

    @Test
    public void test()
    {
        Practice2 test=new Practice2();
        File[] result1=test.getAllSubFiles(path);
        File[] result2=test.getAllSubFilesByLambda(path);
        File[] result3=test.getAllSubFilesByFunction(path);

        for(int i=0;i<result1.length;i++)
        {
            System.out.println(result1[i].toString());
        }
        Assert.assertArrayEquals(result1,result2);
        Assert.assertArrayEquals(result3,result2);
    }
}
