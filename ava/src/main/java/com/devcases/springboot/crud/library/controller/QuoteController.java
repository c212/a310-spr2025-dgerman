package com.devcases.springboot.crud.library.controller;

import com.devcases.springboot.crud.library.entity.Quote;
import com.devcases.springboot.crud.library.model.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class QuoteController {

    @Autowired
    private QuoteService service;

    @GetMapping("/")
    public String showRandomQuote(Model model) {
        Quote quote = service.getRandomQuote();
        model.addAttribute("quote", quote);
        return "random";
    }

    @GetMapping("/list")
    public String showQuotesList(Model model) {
        model.addAttribute("quotes", service.findAll());
        return "quotes";
    }

    @GetMapping("/add")
    public String showAddForm(Quote quote) {
        return "add-quote";
    }

    @PostMapping("/add")
    public String addQuote(@Valid Quote quote, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-quote";
        }
        service.save(quote);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Quote quote = service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid quote Id:" + id));
        model.addAttribute("quote", quote);
        return "edit-quote";
    }

    @PostMapping("/update/{id}")
    public String updateQuote(@PathVariable Long id, @Valid Quote quote, BindingResult result, Model model) {
        if (result.hasErrors()) {
            quote.setId(id);
            return "edit-quote";
        }
        service.save(quote);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuote(@PathVariable Long id, Model model) {
        service.deleteById(id);
        return "redirect:/list";
    }
}
