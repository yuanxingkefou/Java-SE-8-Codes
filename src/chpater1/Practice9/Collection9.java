package chpater1.Practice9;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 编写一个继承Collection接口的子接口Collection9，并添加一个默认方法
 * void forEachIf(Consumer<T> action, Predicate<T> filter),用来将
 * action应用到所有filter并返回true的元素上。
 * @param <T>
 */
public interface Collection9<T> extends Collection<T>{
    default void forEachIf(Consumer<T> action, Predicate<T> filter)
    {
        this.stream().filter(filter::test).forEach(action::accept);
    }
}
