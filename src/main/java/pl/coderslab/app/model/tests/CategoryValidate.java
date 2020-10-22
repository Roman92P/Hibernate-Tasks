//package pl.coderslab.app.model;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Target({ElementType.FIELD, ElementType.PARAMETER})
//@Constraint(validatedBy = CategoryConstraint.class)
//@Retention(value = RetentionPolicy.RUNTIME)
//public @interface CategoryValidate {
//    String message() default "Wrong value";
//
//    Class<?>[] groups() default { };
//
//    Class<? extends Payload>[] payload() default { };
//}
