package chpater2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 编写一个第2.1节中for循环的并行版本。获取处理器的数量，创造出多个独立的线程，每个只处理列表的
 * 一个片段，然后将它们各自的结果汇总起来。
 *
 * 分析：
 * 需要手动将数据进行拆分，然后每个线程选取一个片段去计算
 */
public class Practice1 {
    private static List<String> words;
    private static int CORES=Runtime.getRuntime().availableProcessors();

    public static void prepareData() throws IOException
    {
        String contents=new String(Files.readAllBytes(
                Paths.get("Alice.txt")), StandardCharsets.UTF_8);

        words= Arrays.asList(contents.split("[\\P{L}]+"));
    }
    /**
     * 之前的实现方式
     */
    public static void base() throws Exception
    {
        prepareData();
        int count=0;
        for(String w:words)
        {
            if(w.length()>7)
                count++;
        }
        System.out.println(count);
    }

    /**
     * 使用Lambda的实现方式
     */
    public static void countByLambda() throws Exception
    {
        prepareData();
        long count=words.stream().filter(w->w.length()>7).count();
        System.out.println(count);
    }

    /**
     * 使用并行流
     * @throws Exception
     */
    public static void countByParallel() throws Exception
    {
        prepareData();
        long count=words.parallelStream().filter(w->w.length()>7).count();
        System.out.println(count);
    }

    class MyThread extends Thread
    {
        int start;
        int[] result;
        List<String> words;

        public MyThread(int start,List<String> words,int[] result)
        {
            this.start=start;
            this.words=words;
            this.result=result;
        }

        @Override
        public void run() {
            int count=0;
            for(int i=0;i<words.size()/CORES;i++)
            {
                if ((i * CORES + start) < words.size() && words.get(i * CORES + start).length() > 7)
                    count++;
            }
            result[start]=count;
        }
    }

    public void task() throws IOException, InterruptedException {
        prepareData();
        int[] result = new int[CORES];
        Thread[] threads = new Thread[CORES];
        for (int i = 0; i < CORES; i++) {
            threads[i] = new Thread(new MyThread(i, words, result));
            threads[i].start();
        }
        for (int i = 0; i < CORES; i++) {
            threads[i].join();
        }
        int total = 0;
        for (int i = 0; i < CORES; i++)
            total += result[i];
        System.out.println(total);
    }
    public static void main(String[] args) throws Exception {
        new Practice1().task();
    }
}
