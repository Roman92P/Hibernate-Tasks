package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.Author;
import pl.coderslab.app.repository.AuthorDao;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {
    private AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Autowired
    Validator validator;
    @RequestMapping("/authors")
    public String showAllAuthors(Model model){
        List<Author> allAuthors = authorDao.getAllAuthors();
        model.addAttribute("authors", allAuthors);
        return "authors";
    }
    @RequestMapping("/author/add")
    public String addAuthorForm(Model model){
        model.addAttribute("author", new Author());
        return "addAuthors";
    }
    @PostMapping("/author/add")
    public String addAuthor(@Valid Author author, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addAuthors";
        }
        authorDao.saveAuthor(author);
        return "redirect:/authors";
    }

    @RequestMapping("/author/delete/{id}")
    public String deleteAuthor(@PathVariable long id){
        Author authorById = authorDao.getAuthorById(id);
        authorDao.deleteAuthor(authorById);
        return "redirect:/authors";
    }

    @RequestMapping("/author/edit/{id}")
    public String editAuthor(@PathVariable long id, Model model){
        Author authorById = authorDao.getAuthorById(id);
        model.addAttribute("author", authorById);
        return "addAuthors";
    }

}
