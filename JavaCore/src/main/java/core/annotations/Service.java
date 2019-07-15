package core.annotations;

import java.lang.annotation.*;


/**
 * RetentionPolicy.CLASS - аннотация только в исходном коде (для документации)
 * RetentionPolicy.RUNTIME - видна при компиляции
 * RetentionPolicy.SOURCE - при работе программы
 *
 */
@Documented //Аннотация попадает в javadoc
@Inherited //Аннотация унаследуется потомками класса
@Target(ElementType.TYPE) //Облаласть применения аннотации
@Retention(RetentionPolicy.RUNTIME) //Время жизни аннотации
public @interface Service {

    String name(); //???

    boolean lazyLoad() default false; //????
}


