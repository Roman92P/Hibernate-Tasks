package pl.coderslab.app.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class TestValidator implements ConstraintValidator<ArticleAnotation, Article> {
    @Override
    public void initialize(ArticleAnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(Article article, ConstraintValidatorContext constraintValidatorContext) {
    return false;
    }

}
