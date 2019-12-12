package theory.mapping;


import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.SortComparator;
import org.hibernate.annotations.SortNatural;
import org.hibernate.annotations.Type;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ОТОБРАЖЕНИЕ КОЛЛЕКЦИЙ:
 *
 * @ElementCollection - Обязательная аннотация для отображения множеств
 * @CollectionTable(name = "IMAGE", joinColumns = @JoinColumn(name = "ITEM_ID")) - Имя таблицы для отображения множества,
 * @JoinColumn(name = "ITEM_ID") - столбец для внешнего ключа
 * @Column(name = "FILENAME") - Имя столбца для значений множества
 *
 *
 * @CollectionId(
 *             columns = @Column(name = "IMAGE_ID"),
 *             type = @Type(type = "long"),
 *             generator = "generatorName") - Суррогатный первичный ключ допускает повторения
 *
 * @OrderColumn - Сохраняет порядок в коллекции. Снижает производительность
 *
 *
 * @OrderBy - Добавляет к SQL запросу Order by
 *
 *
 * @SortComparator(RelationsMapping.class) - Отсортированная коллекция с помощью comporator
 *
 *
 * @SortNatural - Отсортированная коллекция с помощью comparable
 *
 *
 *  ОТОБРАЖЕНИЕ СВЯЗЕЙ МЕЖДУ СУЩНОСТЯМИ:
 *
 */
public class RelationsMapping implements Comparator<String> {

    @ElementCollection
    @CollectionTable(name = "IMAGE", joinColumns = @JoinColumn(name = "ITEM_ID"))
    @Column(name = "FILENAME")
    Set<String> images = new HashSet<>(); //Для множества Set первичный ключ составной - ITEM_ID и FILENAME


    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @Column(name = "FILENAME")
    @CollectionId(
            columns = @Column(name = "IMAGE_ID"),
            type = @Type(type = "long"),
            generator = "generatorName")
    @OrderColumn
    List<String> images2 = new ArrayList<>();


    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @MapKeyColumn(name = "FILENAME")
    @Column(name = "IMAGE_NAME")
    @SortComparator(RelationsMapping.class)
    Map<String, String> images3 = new HashMap<>();




    @Override
    public int compare(String o1, String o2) {
        return 0;
    }
}
