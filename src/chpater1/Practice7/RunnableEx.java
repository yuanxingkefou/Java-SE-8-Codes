package chpater1.Practice7;

/**
 * 编写一个静态方法andThen，它接收两个Runnable实例作为参数，并返回一个分别运行这两个实例
 * 的Runnable对象。在main方法中，向andThen方法传递两个Lambda表达式，并运行返回的实例。
 */
public interface RunnableEx {
    void run();

    static Runnable andThen(Runnable a,Runnable b)
    {
        return ()->{
            new Thread(a).start();
            new Thread(b).start();
        };
    }
}
