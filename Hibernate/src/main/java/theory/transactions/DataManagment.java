package theory.transactions;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.OneToMany;
import java.util.Set;

/**
 *
 * @LazyCollection(LazyCollectionOption.EXTRA) - Поддержка операций с коллекцией не вызывающий ее инициализацию.
 *  size, isEmpty, contains. Список List загрузит только один элемент при вызове get(index).
 *
 *
 */

public class DataManagment {

    @OneToMany
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Set<String> stringSet;
}
