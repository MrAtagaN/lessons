package libs.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Кастомная валидация
 */
@Constraint(validatedBy = {CheckChronDates.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChronDates {

    String message() default "deathDate must be after berthDay";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
