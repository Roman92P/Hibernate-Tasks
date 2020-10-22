package pl.coderslab.app.model.tests;

import pl.coderslab.app.model.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CategoryConstraint implements ConstraintValidator<CategoryValidate, List<Category>> {
   public void initialize(CategoryValidate constraint) {
   }

   public boolean isValid(List<Category> categories, ConstraintValidatorContext context) {
      return categories.size()>=1;
   }
}
