package com.example.demo.contoller;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.ArticleService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@RestController
public class Blog {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired(required = true)
    private ArticleService articleService;

    @GetMapping("/")
    public String helloWorld(){
        return "Helo world";
    }

    @GetMapping("/getAllArticle")
    public List<Article> findAllArticle(){

        return articleRepository.findAll();
    }

    @GetMapping("/article/{id}")
    public Article asd(@PathVariable(value = "id") Long id){

        Article article = articleService.findArticleById(id);


    return article;
    }


    @PostMapping("/")
    public Article addArticle(@RequestBody Article article){
        articleService.addArticle(article);
    return article;
    }
}
