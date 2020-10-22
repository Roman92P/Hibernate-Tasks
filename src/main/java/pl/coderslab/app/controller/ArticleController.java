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
import pl.coderslab.app.model.Article;
import pl.coderslab.app.model.Author;
import pl.coderslab.app.model.Category;
import pl.coderslab.app.model.Draft;
import pl.coderslab.app.repository.ArticleDao;
import pl.coderslab.app.repository.AuthorDao;
import pl.coderslab.app.repository.CategoryDao;
import pl.coderslab.app.repository.DraftRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

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
    public String addNewArticle(@Valid Article article, BindingResult result,HttpServletRequest httpServletRequest){
        if(result.hasErrors()){
            return "addArticle";
        }
        articleDao.saveArticle(article);
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
