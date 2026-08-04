package com.ufcpedia.news.repository;

import com.ufcpedia.news.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findTop5ByOrderByPublishDateDesc();

    List<News> findByTitleContainingIgnoreCase(String keyword);

}