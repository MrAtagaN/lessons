package theory.mapping;


import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Entity(name = "CustomName") - Именование сущности в запросах
 * PhysicalNamingStrategy - Интерфейс переопределяющий наименования по умолчанию
 *
 *
 * @DynamicUpdate
 * @DynamicInsert - Динамическое формирование запросов. Используется для оптимизации запросов к таблицам с большим
 * количеством столбцов
 *
 *
 * @Immutable - Оптимизация для неизменяемых сущностей
 *
 *
 * @Subselect(value = "select .. as name from ... <HQL>") - Сущность доступная только на чтение, формируется запросом.
 * @Synchronize({"<Entity_1>","<Entity_2>"}) - Сущности упомянутые в @Subselect должны быть перечислены в этой аннотации
 *
 *
 * @Embedded - отмечается свойство как встроенный компонент класса-владельца
 * @Embeddable - отмечается класс как встроенный компонент класса-владельца
 *
 *
 * Проверка на нулевые значения:
 * @Basic(optional = false)
 * @NotNull
 * @Column(nullable = false)
 *
 *
 * @Access(AccessType.FIELD) - Настройка доступа к свойствам. Можно ставить над классом или полем. По умолчанию
 * определяется в зависимости от места аннотации @Id (над свойством или методом)
 *
 *
 * @Formula("<HQL>") - вычисляемое запросом поле. Доступнотолько для чтения
 *
 */

@Entity(name = "CustomName")
@DynamicInsert
@DynamicUpdate
@Immutable
@Subselect(value = "<HQL>")
@Synchronize({"<Entity_1>","<Entity_2>"})
@Access(AccessType.FIELD)
public class EntityMapping extends PhysicalNamingStrategyStandardImpl {

    @Id
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    String name;

    @Formula("<HQL>")
    String secondName;

    @Embedded
    Adress adress;


    @Embeddable
    private static class Adress {
        String number;
    }
}
