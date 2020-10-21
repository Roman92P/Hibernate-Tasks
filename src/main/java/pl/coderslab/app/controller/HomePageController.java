package pl.coderslab.app.controller;

import javassist.runtime.Desc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.Article;
import pl.coderslab.app.repository.ArticleDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomePageController {

    private ArticleDao articleDao;

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
}
