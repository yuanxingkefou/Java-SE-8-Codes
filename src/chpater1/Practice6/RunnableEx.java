package chpater1.Practice6;

/**
 * 编写一个捕获所有异常的uncheck方法，再将它改造为不需要检查异常的方法，
 * 在uncheck方法中使用一个Lambda表达式
 */
public interface RunnableEx {
     void run() throws Exception;

     static Runnable uncheck(RunnableEx runner)
     {
         return ()->{
             try {
                 runner.run();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         };
     }
}
