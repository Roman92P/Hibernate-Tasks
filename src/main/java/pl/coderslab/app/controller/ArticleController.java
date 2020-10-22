package pl.coderslab.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.*;
import pl.coderslab.app.repository.ArticleDao;
import pl.coderslab.app.repository.AuthorDao;
import pl.coderslab.app.repository.CategoryDao;
import pl.coderslab.app.repository.DraftRepository;


import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/articles")
@AllArgsConstructor
public class ArticleController {


    @Autowired
    Validator validator;
   private final ArticleDao articleDao;
   private final AuthorDao authorDao;
   private final CategoryDao categoryDao;
   private final DraftRepository draftRepository;

    @RequestMapping
    public String showAllArticles(Model model){
        model.addAttribute("articles", articleDao.getAllArticles());
        return "articles";
    }

    @RequestMapping("/add")
    public String addArticleForm(Model model){
        model.addAttribute("article", new Article());
        return "addArticle";
    }

    @PostMapping("/add")
    public String addNewArticle(@Valid Article article, @Valid Draft draft){
        Set<ConstraintViolation<Article>> validate = validator.validate(article);

        Set<ConstraintViolation<Draft>> validate1 = validator.validate(draft, ValidationOne.class);
        if(validate1.isEmpty()){
            draftRepository.save(draft);
            return "redirect:/draft";
        }

        if (!validate.isEmpty()&&!validate1.isEmpty()) {
            return "addArticle";
        }
        else if(validate.isEmpty()&&!validate1.isEmpty()) {
            articleDao.saveArticle(article);
        }
        return "redirect:/articles";
    }

    @RequestMapping("/delete/{id}")
    public String deleteArticle(@PathVariable long id){
        Article artickleById = articleDao.getArtickleById(id);
        articleDao.deleteArticle(artickleById);
        return "redirect:/articles";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return this.categoryDao.getAllCategories();
    }
    @ModelAttribute("authors")
    public List<Author> getAuthors(){
        return this.authorDao.getAllAuthors();
    }


}
