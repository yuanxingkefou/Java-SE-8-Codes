package chpater1.Practice9;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args)
    {
        MyList<String> list=new MyList<>();

        list.add("hello");
        list.add("java");
        list.add("in");
        list.add("action");

        list.forEachIf(System.out::println,s->s.length()>4);
    }
}
class MyList<T> extends ArrayList<T> implements Collection9<T>
{

}
