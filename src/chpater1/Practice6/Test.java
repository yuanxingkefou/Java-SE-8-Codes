package chpater1.Practice6;

public class Test {
    public static void main(String[] args)
    {
        //无需抛出异常
        new Thread(RunnableEx.uncheck(()->{
            System.out.println("Zzz1");
            Thread.sleep(100);
        })).start();

        //原有实现，需要抛出异常
        new Thread(()->{
            System.out.println("Zzz2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
