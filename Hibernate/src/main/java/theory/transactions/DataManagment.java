package theory.transactions;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
 *
 */

public class DataManagment {


    @OneToMany(fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<String> stringSet;
}
