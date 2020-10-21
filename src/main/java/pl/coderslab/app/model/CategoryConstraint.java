package pl.coderslab.app.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CategoryConstraint implements ConstraintValidator<ValidateCategory, List<Category>> {
    private Category category;

    @Override
    public void initialize(ValidateCategory constraintAnnotation) {

    }

    @Override
    public boolean isValid(List<Category> categories, ConstraintValidatorContext constraintValidatorContext) {
        int size = categories.size();
        System.out.println("Wielkość: "+ size);
        if(size==0){
            return false;
        }else
        return true;
    }
}
