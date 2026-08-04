package com.ufcpedia.news.service;

import com.ufcpedia.news.entity.News;
import com.ufcpedia.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository repository;

    public List<News> getAllNews() {
        return repository.findAll();
    }

    public List<News> getTopStories() {
        return repository.findTop5ByOrderByPublishDateDesc();
    }

    public News getNews(Long id) {
        return repository.findById(id).orElse(null);
    }

    public News saveNews(News news) {
        return repository.save(news);
    }

    public void deleteNews(Long id) {
        repository.deleteById(id);
    }

    public List<News> searchNews(String keyword) {
        return repository.findByTitleContainingIgnoreCase(keyword);
    }
}