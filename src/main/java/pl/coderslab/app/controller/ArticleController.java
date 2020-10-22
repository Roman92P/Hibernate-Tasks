package pl.coderslab.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.*;
import pl.coderslab.app.repository.ArticleDao;
import pl.coderslab.app.repository.AuthorDao;
import pl.coderslab.app.repository.CategoryDao;
import pl.coderslab.app.repository.DraftRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
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
    public String showAllArticles(Model model) {
        model.addAttribute("articles", articleDao.getAllArticles());
        return "articles";
    }

    @RequestMapping("/add")
    public String addArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "addArticle";
    }

    @PostMapping("/add")
    public String addNewArticle(@Valid Article article, BindingResult result) {
        boolean draft = article.isDraft();
        if(draft) {
            Set<ConstraintViolation<Article>> validate = validator.validate(article, DraftValid.class);
            if (validate.isEmpty()) {
                draftRepository.save(new Draft(article.getTitle(), article.getContent()));
                return "redirect:/articles";
            }
        }
        Set<ConstraintViolation<Article>> validate1 = validator.validate(article, ArticleValid.class);
        if (validate1.isEmpty()) {
            articleDao.saveArticle(article);
            return "redirect:/articles";
        }
        return "addArticle";
    }

    @RequestMapping("/delete/{id}")
    public String deleteArticle(@PathVariable long id) {
        Article artickleById = articleDao.getArtickleById(id);
        articleDao.deleteArticle(artickleById);
        return "redirect:/articles";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return this.categoryDao.getAllCategories();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return this.authorDao.getAllAuthors();
    }


}
