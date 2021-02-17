package core.annotations;

import java.lang.annotation.*;


/**
 *
 * Retention - Время жизни аннотации
 *  CLASS - аннотация только в исходном коде (для документации)
 *  RUNTIME - видна при компиляции
 *  SOURCE - при работе программы
 *
 * Target - Облаласть применения аннотации
 *
 */
@Documented //Аннотация попадает в javadoc
@Inherited //Аннотация унаследуется потомками класса
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyService {

    String name(); //обязательный параметр в аннотации (нужно задавать)

    boolean lazyLoad() default false; //необязательный параметр, значение по умолчанию (необязательное значение)
}


