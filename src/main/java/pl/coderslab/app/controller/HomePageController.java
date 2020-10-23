package pl.coderslab.app.controller;

import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.Article;
import pl.coderslab.app.model.Category;
import pl.coderslab.app.repository.ArticleDao;
import pl.coderslab.app.repository.ArticleRepository;
import pl.coderslab.app.repository.CategoryRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomePageController {

    private ArticleDao articleDao;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ArticleRepository  articleRepository;


    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @RequestMapping("/")
    public String home(Model model) {
        List<Article> allArticles = articleDao.getAllArticles();
        List<Article> articleList = allArticles.stream()
                .limit(5)
                .collect(Collectors.toList());
        model.addAttribute("articles", articleList);
        return "/home";
    }
    //    Na stronie startowej - kontroler HomePageController ,
    //    akcja home() wyświetl listę kategorii.
    //    Nazwy kategorii mają stanowić linki do nowej akcji
    //    kontrolera, w której wyświetlimy listę wszystkich artykułów z klikniętej kategorii.
    @RequestMapping("/home")
    public String homeTwo(Model model){
        List<Category> all = categoryRepository.findAll();
        model.addAttribute("categories", all);
        return "homeTwo";
    }
    @RequestMapping("/home/category/{id}")
    public String showCategoryArticle(@PathVariable long id, Model model){
        List<Article> articleByCategoryListContaining = articleRepository.getArticleByCategoryListContaining(id);
        model.addAttribute("categoryArticles", articleByCategoryListContaining);
        return "showCategoryArticles";
    }
}
