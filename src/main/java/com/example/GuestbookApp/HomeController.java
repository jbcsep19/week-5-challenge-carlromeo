package com.example.GuestbookApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    GuestbookRepository guestbookRepository;

    @RequestMapping("/")
    public String homepage(Model model){model.addAttribute("guestbooks", guestbookRepository.findAll());
        return "homepage";
    }

    @RequestMapping("/list")
    public String listGuestbooks(Model model){model.addAttribute("guestbooks", guestbookRepository.findAll());
    return "list";
    }

    @GetMapping("/add")
    public String guestbookform(Model model){model.addAttribute("guestbook", new Guestbook());
    return "guestbookform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Guestbook guestbook, BindingResult result){
        if (result.hasErrors()){
            return "guestbookform";}
        guestbookRepository.save(guestbook);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showGuestbook(@PathVariable("id") long id, Model model) {
        model.addAttribute("guestbook", guestbookRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateGuestbook(@PathVariable("id") long id, Model model) {
        model.addAttribute("guestbook", guestbookRepository.findById(id).get());
        return "guestbookform";
    }

    @RequestMapping("/delete/{id}")
    public String delguestbook(@PathVariable("id") long id) {
        guestbookRepository.deleteById(id);
        return "redirect:/";
    }

}
