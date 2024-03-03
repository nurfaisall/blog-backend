package com.example.demo.contoller;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.ArticleService;
import com.fasterxml.jackson.databind.util.JSONPObject;
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

//    @GetMapping("/")
//    public JSONObject helloWorld(){
//        JSONPObject jo = new JSONPObject("tset","test");
//        jo.put
//
//        return new JSONPObject("test", "test");
//    }

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

    @DeleteMapping("deleteArticle/{id}")
    public void deleteArticle(@PathVariable(value = "id")Long id){

        articleService.deleteArticleById(id);

    }

    @DeleteMapping("/")
    public void deleteAllArticle(){
        articleService.deleteAllArticle();
    }
}
