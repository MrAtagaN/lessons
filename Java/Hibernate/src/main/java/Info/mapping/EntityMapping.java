package Info.mapping;


import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;
import org.hibernate.annotations.Type;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeConverter;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Converter;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

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
 * @Immutable - Оптимизация для неизменяемых сущностей, Hibernate не отслеживает изменения
 *
 *
 * @Subselect(value = "select .. as name from ... <HQL>") - Сущность доступная только на чтение, формируется запросом.
 * @Synchronize({"<Entity_1>","<Entity_2>"}) - Сущности упомянутые в @Subselect должны быть перечислены в этой аннотации
 *
 *
 * @Embedded - отмечается свойство как встроенный компонент класса-владельца
 * @Embeddable - отмечается класс как встроенный компонент класса-владельца
 *
 * @AttributeOverrides({@AttributeOverride(name = "attr_name", column = @Column(name = "column_name"))}) - выборочно
 * переопределяет отображение свойств встроеного класса. Нужно чтобы имена колонок не повторялись в одной таблице
 *
 *
 * Проверка на нулевые значения:
 * @Basic(optional = false)
 * @Column(nullable = false)
 * @NotNull - это ограничение не отображается в DDL схеме
 *
 *
 * @Access(AccessType.FIELD) - Настройка доступа к свойствам. Можно ставить над классом или полем. По умолчанию
 * определяется в зависимости от места аннотации @Id (над свойством или методом). Встраиваемые классы наследуют доступ.
 *
 *
 * @Formula("<HQL>") - вычисляемое запросом поле. Доступнотолько для чтения
 *
 *
 * @ColumnTransformer(read = "<HQL>", write = "<HQL>") - Преобразование значений столбцов. Значение не индексируется
 *
 *
 * @Generated(GenerationTime.INSERT) - Значение генерирует Hibernate. Свойство должно быть только на чтение
 * @ColumnDefault("1.00") - Дефолтное значение при экспорте или формировании DDL схемы
 *
 *
 * Срецификация JPA требует использовать аннотацию @Temporal
 * @Temporal(TemporalType.DATE) - Отображение в базе: yyyy-MM-dd
 * @Temporal(TemporalType.TIME) - Отображение в базе: HH:mm:ss
 * @Temporal(TemporalType.TIMESTAMP) - Отображение в базе: yyyy-MM-dd HH:mm:ss.SSS  Timestamp - точность до наносекунд.
 * Используется по умолчанию в Hibernate.
 *
 *
 * @Enumerated(EnumType.STRING) - Отображение перечеслений. По умолчанию ORDINAL. Лучше использовать STRING
 *
 *
 * @Lob - отображение в SQL тип CLOB или BLOB. Не обеспечвает отложенную загрузку. Для отложенной загрузки должен быть
 * тип java.sql.Blob или java.sql.Clob
 *
 * @Type(type = "yes_no") - переопределение адаптера
 *
 * @Converter(autoApply = true) - Аннотация для класса конвертера. Класс должен реализовывать
 * интерфейс AttributeConverter<X, Y>
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

    @ColumnTransformer(read = "<HQL>", write = "<HQL>")
    Integer sum;

    @Generated(GenerationTime.INSERT)
    @ColumnDefault("1.00")
    Integer average;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "attr_name", column = @Column(name = "column_name"))})
    Adress adress;

    @Temporal(TemporalType.TIMESTAMP)
    Date date;

    @Enumerated(EnumType.STRING)
    Action action;

    @Lob
    byte[] image;

    @Type(type = "yes_no")
    boolean verified;



    @Embeddable
    private static class Adress {
        String number;
    }

    private enum Action {
        A, B
    }


    @Converter(autoApply = true)
    public static class CustomConverter implements AttributeConverter<String, Integer> {
        @Override
        public Integer convertToDatabaseColumn(String s) {
            return null;
        }

        @Override
        public String convertToEntityAttribute(Integer integer) {
            return null;
        }
    }
}
