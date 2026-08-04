package com.ufcpedia.news.controller;

import com.ufcpedia.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsPageController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public String news(
            @RequestParam(required = false) String keyword,
            Model model) {

        if (keyword != null && !keyword.isBlank()) {
            model.addAttribute("newsList",
                    newsService.searchNews(keyword));
        } else {
            model.addAttribute("newsList",
                    newsService.getAllNews());
        }

        model.addAttribute("keyword", keyword);

        return "news";
    }

    @GetMapping("/news/{id}")
    public String newsDetails(@PathVariable Long id,
                              Model model) {

        model.addAttribute(
                "news",
                newsService.getNews(id));

        return "news-details";
    }
}