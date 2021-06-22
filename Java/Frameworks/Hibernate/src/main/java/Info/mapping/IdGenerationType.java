package Info.mapping;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * GenerationType.AUTO - Hibernate выбрает подходящую стратегию, исходя из диалекта SQL.
 *
 * GenerationType.SEQUENCE - Hibernate ищет (и создает, если использовать определенные инструменты) последовательность
 * HIBERNATE_SEQUENCE в базе данных. Эта Последовательность будет вызываться перед каждой операцией INSERT для получения
 * последовательных чисел
 *
 * GenerationType.IDENTITY - Hibernate ищет (и создает в DDL-определении таблицы) специальный столбец первичного ключа
 * с автоматическим приращиванием, который сам генерирует числовое значение во время операциии INSERT
 *
 * GenerationType.TABLE - Hibernate будет использовать дополнительную таблицу в базе данных, зранящую следующее числовое
 * значение первичного ключа: по одной строке на каждый класс сущности. Эта таблица будет читаться и обновляться перед
 * выполнение INSERT. По умолчанию таблица называется HIBERNATE_SEQUENCE и содержит столбцы SEQUENCE_NAME и
 * SEQUENCE_NEXT_HI_VALUE.
 *
 *
 * Стратегии генераторов значений:
 * native -
 * sequence -
 * sequence-identity -
 * enhanced-sequence -
 * seqhilo -
 * hilo -
 * enhanced-table -
 * identity -
 * increment -
 * select -
 * uuid32 -
 * guid -
 *
 *
 *
 * Настройка именованных генераторов в JPA:
 * @SequenceGenerator()
 * @TableGenerator()
 * Настройка именованных генераторов в Hibernate:
 * @GenericGenerator()
 * Эти аннотации могут быть перед пустыми классами
 *
 * Рекомендации:
 *  -Использовать стратегии производящие значения идентификатора независимо, перед выполнением INSERT, т.к это повышает
 *   производительность
 *  -Использовать enhanced-sequence, которая работает со встроенной последовательностью в базе данных
 *
 *
 * https://thoughts-on-java.org/jpa-generate-primary-keys/
 */


/**
 * JPA стратегии
 */
@Entity
public class IdGenerationType {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(nullable = false, updatable = false)
    private Long id;


    /**
     * Именованный генератор значений
     */
    @Entity
    private class Generator {
        @Id
        @GeneratedValue(generator = "ID_GENERATOR")
        @GenericGenerator(
                name = "ID_GENERATOR",
                strategy = "enhanced-sequence", //стратегия
                parameters = {
                        @Parameter(name = "sequence_name", value = "JPWH_SEQUENCE"), //имя последовательности
                        @Parameter(name = "initial_value", value = "1000"), //начальное значение
                })
        private Long id;
    }


    /**
     * Именованный генератор значений
     */
    @Entity
    private class Hilo {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilo_sequence_generator")
        @GenericGenerator(
                name = "hilo_sequence_generator",
                strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
                parameters = {
                        @Parameter(name = "sequence_name", value = "hilo_seqeunce"),
                        @Parameter(name = "initial_value", value = "1"),
                        @Parameter(name = "increment_size", value = "3"),
                        @Parameter(name = "optimizer", value = "hilo")
                })
        private Long id;
    }
}
