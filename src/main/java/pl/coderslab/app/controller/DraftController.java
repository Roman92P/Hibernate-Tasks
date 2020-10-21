package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.Draft;
import pl.coderslab.app.repository.DraftRepository;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/draft")
public class DraftController {

    @Autowired
    DraftRepository draftRepository;

    @RequestMapping
    public String showAllDrafts(Model model){
        List<Draft> all = draftRepository.findAll();
        model.addAttribute("drafts", all);
        return "showDrafts";
    }

    @RequestMapping("/add")
    public String addDraft(Model model){
        model.addAttribute("draft", new Draft());
        return "addDraft";
    }
    @PostMapping("/add")
    public  String addDraftFromForm(Draft draft){
        draftRepository.save(draft);
        return "showDrafts";
    }

}
