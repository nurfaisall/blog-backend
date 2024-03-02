package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "article")
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "article_text")
    String articleText;

    @Column(name = "created_at")
    Timestamp createdAt;

    @Column(name = "update_at")
    Timestamp updateAt;

    @Column(name = "created_by")
    Long createdBy;


}
