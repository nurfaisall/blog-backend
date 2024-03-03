package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article addArticle(Article article){
        Date date = new Date();
        article.setCreatedAt(new Timestamp(date.getTime()));

        articleRepository.save(article);
        return article;
    }

    public List<Article> findAllArticle(){
        return articleRepository.findAll();

    }

    public Article findArticleById(Long id){

        Article article = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found exception for id = " + id));

        return article;
    }

    public void deleteArticleById(Long id){
        articleRepository.deleteById(id);
    }

    public void deleteAllArticle(){
        articleRepository.deleteAll();
    }

}
