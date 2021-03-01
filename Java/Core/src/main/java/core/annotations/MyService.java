package core.annotations;

import java.lang.annotation.*;


/**
 *
 * Retention - Время жизни аннотации
 *  RUNTIME - видна при работе программы
 *  CLASS - видна в классе после компиляции, но не видна при работе программы. По умолчанию
 *  SOURCE - аннотация только в исходном коде (для документации)
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


