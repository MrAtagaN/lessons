package theory.transactions;

import org.hibernate.annotations.*;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @LazyCollection(LazyCollectionOption.EXTRA) - Поддержка операций с коллекцией не вызывающий ее инициализацию.
 * size, isEmpty, contains. Список List загрузит только один элемент при вызове get(index).
 *
 *
 *  Проблема N + 1
 *
 *  Решения:
 *  @OneToMany(fetch = FetchType.EAGER) - По умолчанию использует стратегию JOIN. Работает для связей @OneToMany @OneToOne
 *  если извлекается одна коллекция, иначе возникает проблема декартова произведения
 *
 *  Массовая предварительная выборка данных:
 *  @BatchSize(size = 10) - При загрузке одного прокси объекта, может быть загружено до 10 объектов. Аннотация ставится
 *  над коллекцией или над классом
 *
 *  Предварительное извлечение подзапросов с помощью подзапросов:
 *  @Fetch(FetchMode.SUBSELECT) - Как только инициализируется одна из коллекций, Hibernate инициализирует все коллекции.
 *  На момент написания доступна только для коллекций с планом отложенной загрузки, но не для прокси-обектов сущностей.
 *
 *  Отложенное извлечение с несколькими выражениями SELECT:
 *  @OneToMany(fetch = FetchType.EAGER)
 *  @Fetch(FetchMode.SELECT)
 */

@BatchSize(size = 10)
public class DataManagment {

    @OneToMany(fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.EXTRA)
    @BatchSize(size = 10)
    @Fetch(FetchMode.SUBSELECT)
    private Set<String> stringSet= new HashSet<>();
}
