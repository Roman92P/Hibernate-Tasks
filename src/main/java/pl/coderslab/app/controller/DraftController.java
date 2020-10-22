package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.Draft;
import pl.coderslab.app.repository.DraftRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Transactional
@RequestMapping("/draft")
public class DraftController {

    @Autowired
    DraftRepository draftRepository;

    @RequestMapping
    public String showAllDrafts(Model model) {
        List<Draft> all = draftRepository.findAll();
        model.addAttribute("drafts", all);
        return "showDrafts";
    }

    @RequestMapping("/add")
    public String addDraft(Model model) {
        model.addAttribute("draft", new Draft());
        return "addDraft";
    }

    @PostMapping("/add")
    public String addDraftFromForm(@Valid Draft draft, BindingResult result) {
        if(result.hasErrors()){
            return "addDraft";
        }
        draftRepository.save(draft);
        return "redirect:/draft";
    }

    @RequestMapping("/delete/{id}")
    public String deleteDraft(@PathVariable long id) {
        Optional<Draft> byId = draftRepository.findById(id);
        if (byId.isPresent()) {
            Draft draft = byId.get();
            draftRepository.delete(draft);
        }
        return "redirect:/draft";
    }

    @RequestMapping("/edit/{id}")
    public String updateDraft(@PathVariable long id, Model model) {
        Optional<Draft> byId = draftRepository.findById(id);
        Draft draft = null;
        if (byId.isPresent()) {
            draft = byId.get();
        }
        model.addAttribute("draft", draft);
        return "addDraft";
    }

}
