package Info.mapping;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hibernate.annotations.FetchMode.SUBSELECT;

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
 *  @ManyToOne - однонаправленая связь
 *  @JoinColumn(name = "PARENT_ID", nullable = false) - название столбца с внешним ключом
 *
 *  Если нет двунаправленой связи и разделяемых ссылок на объекты множества лучше использовать @ElementCollection
 *
 *  @OneToMany - двунаправленная связь
 *  mappedBy = "parent" - аттрибут на другой стороне, который ссылается на данную сущность
 *  CascadeType.PERSIST - Действие которое будет применяться к объектам множества
 *  orphanRemoval = true - Удаление объекта из базы, если он был удален из данного множества
 *  @OnDelete(action = OnDeleteAction.CASCADE) - каскадное удаление на уровне базы. Работает быстрее.
 *
 *  Каскадные удаления медленные. Нужно применять только если нет разделяемых ссылок. Лучше не применять
 *
 *  @OneToOne - связь один к одному
 *  стратегии отображения:
 *  Общий первичный ключ - @PrimaryKeyJoinColumn
 *  Генератор внешнего первичного ключа -
 *  Соединение с помощью столбца внешнего ключа - @JoinColumn
 *  Использование таблицы соединения - @JoinTable(name = "", joinColumns = @JoinColumn(name = ""), inverseJoinColumns = @JoinColumn(name = ""))
 *
 *
 * @Fetch(SUBSELECT) - Способ вычитать из базы связанные сущности
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

    //двунаправленая связь, т.е. у Auto есть ссылка на User, а у User есть ссылка на Auto
    //чтобы Hibernate понимал эту связь, нужно указывать mappedBy, в котором указать имя атрибута ссылающегося на данный объект
    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE) //на уровне базы
    @Fetch(SUBSELECT)
    Set<Image> images4;


    @JoinTable(name = "", joinColumns = @JoinColumn(name = ""), inverseJoinColumns = @JoinColumn(name = ""))
    @PrimaryKeyJoinColumn
    @OneToOne
    Image image;


    @Override
    public int compare(String o1, String o2) {
        return 0;
    }

    @Entity
    private class Image {

        @ManyToOne(fetch = FetchType.LAZY) //по умолчанию EAGER
        @JoinColumn(name = "PARENT_ID", nullable = false)
        RelationsMapping parent;
    }
}
