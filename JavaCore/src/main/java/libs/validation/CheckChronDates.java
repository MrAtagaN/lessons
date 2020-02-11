package libs.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Валидация для анннотации ChronDates
 */
public class CheckChronDates implements ConstraintValidator<ChronDates, Main.Person> {



    @Override
    public boolean isValid(Main.Person person, ConstraintValidatorContext constraintValidatorContext) {
        return person.birthday.isBefore(person.deathDay);
    }
}
