package chpater1.Practice7;

public class Test {
    public static void main(String[] args)
    {
        Runnable a=()->System.out.println("a");

        Runnable b=()->System.out.println("b");

        new Thread(RunnableEx.andThen(a,b)).start();
    }
}
