package com.mycompany.webblog.controllers;

import com.mycompany.webblog.Model.Article;
import com.mycompany.webblog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {


    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping(value = "/blog/add")
    public String blogArticleAdd(
            @RequestParam String title,
            @RequestParam String anons,
            @RequestParam String full_text,
            Model model
    ) {
        Article article = new Article(title, anons, full_text);
        articleRepository.save(article);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String articleDetails(@PathVariable(value = "id") long id, Model model) {
        if (!articleRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Article> optionalArticle = articleRepository.findById(id);
        ArrayList<Article> res = new ArrayList<>();
        //optionalArticle.ifPresent(res::add);
        if (optionalArticle.isPresent()) {
            // Получаем объект Article из Optional

            Article article = optionalArticle.get();
            res.add(article);
            article.incrementOfViews();
            articleRepository.save(article);
            model.addAttribute("article", res);
        }
        return "article-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String articleEdit(@PathVariable(value = "id") long id, Model model) {

        if (!articleRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Article> article = articleRepository.findById(id);
        ArrayList<Article> res = new ArrayList<>();
        article.ifPresent(res::add);
        model.addAttribute("article", res);
        return "article-edit";
    }

    @PostMapping(value = "/blog/{id}/edit")
    public String blogArticleEdit(
            @PathVariable(value = "id") long id,
            @RequestParam String title,
            @RequestParam String anons,
            @RequestParam String full_text,
            Model model
    ) {
        Article article = articleRepository.findById(id).orElseThrow();
        articleRepository.save(article);
        article.setTitle(title);
        article.setAnons(anons);
        article.setFull_text(full_text);
        articleRepository.save(article);

        return "redirect:/blog";
    }

    @PostMapping(value = "/blog/{id}/remove")
    public String blogArticleDelete(@PathVariable(value = "id") long id, Model model) {

        Article article = articleRepository.findById(id).orElseThrow();
        articleRepository.delete(article);
        return "redirect:/blog";
    }
}
