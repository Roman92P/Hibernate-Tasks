package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.Category;
import pl.coderslab.app.repository.CategoryDao;

import javax.validation.Valid;
import java.util.List;

//    Utwórz kontroler CategoryController, utwórz w nim akcje, które pozwolą:
//
//    wyświetlić listę wszystkich kategorii
//    dodać kategorię
//    usunąć kategorię
//    edytować kategorię
//
//    Dla akcji dodawania oraz edycji utwórz formularz.
//    Utwórz linki nawigacyjne umożliwiające
//    przechodzenie między akcjami - bez konieczności znania adresów URL.
@Controller
public class CategoryController {

    @Autowired
    Validator validator;

    private CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping("/cat")
    public String showAllCategories(Model model){
        List<Category> allCategories = categoryDao.getAllCategories();
        model.addAttribute("categories", allCategories);
        return "category";
    }
    @RequestMapping("/cat/delete/{id}")
    public String deleteCategory(@PathVariable long id){
        Category categoryById = categoryDao.getCategoryById(id);
        categoryDao.deleteCategory(categoryById);
        return "redirect:/cat";
    }
    @RequestMapping("/cat/add")
    public String addNewCategory(Model model){
        model.addAttribute("category", new Category());
        return "addCategoryForm";
    }
    @PostMapping("/cat/add")
    public String saveCategoryFromForm(@Valid Category category, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addCategoryForm";
        }

        categoryDao.saveCategory(category);
        return "redirect:/cat";
    }
    @RequestMapping("/cat/edit/{id}")
    public String editCategory(@PathVariable long id, Model model){
        Category categoryById = categoryDao.getCategoryById(id);
        model.addAttribute("category", categoryById);
        return "addCategoryForm";
    }
}
