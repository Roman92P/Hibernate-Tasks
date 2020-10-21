package pl.coderslab.app.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {TestValidator.class})
public @interface ArticleAnotation {
    String message() default ("wrong");
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
