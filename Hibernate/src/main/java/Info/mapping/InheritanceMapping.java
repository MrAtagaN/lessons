package Info.mapping;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Одна таблица для каждого конкретного класса и неявный полиморфизм
 * @MappedSuperclass - Суперкласс не является сущностью (Entity). Для суперкласса нет таблицы.
 * Все подклассы отображаются на разные таблицы.
 * Минусы:
 * - Отсутствует полиморфизм, т.к. нет сущности отображающей абстрактный класс
 * - Переименование параметра требует изменения столбцов в нескольких таблицах
 *
 *
 * Одна таблица для каждого конкретного класса с объединением
 * @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) - Суперкласс является сущностью (Entity), но для него нет
 * отдельной таблицы.
 * Минусы:
 * - Не является обязательной стратегией. JPA может не поддерживать.
 *
 *
 * Единая таблица для иерархии класов
 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE) - Вся иерархия классов в одной таблице. Конкретный подкласс
 * определяется значением дополнительного столбца @DiscriminatorColumn(name = "columnName")
 * Плюсы:
 * - Лучшая производительность и простота
 * Минусы:
 * - Нельзя на уровне базы проверять столбцы на NULL
 * - Отсутствует нормализация, что может привести к сложностям в сопровождении
 *
 *
 * Одна таблица для каждого конкретного подкласса с использованием соединений
 * @Inheritance(strategy = InheritanceType.JOINED) - Таблица конкретной сущности (подкласса) содержит только столбцы
 * ненаследуемых свойств. Таблицы обединяет общий первичный ключ.
 * Плюсы:
 * - Нормализация схемы
 * Минусы:
 * - Сложные запросы вручную
 * - При сложной иерархии проблемы с произодительнотью
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "columnName")
public class InheritanceMapping {
}
