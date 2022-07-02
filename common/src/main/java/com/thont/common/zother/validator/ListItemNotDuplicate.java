package com.thont.common.zother.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = ListItemNotDuplicateImpl.class)
@Documented
public @interface ListItemNotDuplicate {
    String message() default "some item is duplicate";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
