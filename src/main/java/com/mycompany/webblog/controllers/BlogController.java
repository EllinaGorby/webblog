package com.mycompany.webblog.controllers;

import com.mycompany.webblog.Model.Article;
import com.mycompany.webblog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "blog-main";
    }
    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @PostMapping(value = "/blog/add")
    public String BlogArticleAdd(
            @RequestParam String title,
            @RequestParam String anons,
            @RequestParam String full_text,
            Model model
    ){
        Article article = new Article(title, anons, full_text);
        articleRepository.save(article);
        return "redirect:/blog";
    }
}
