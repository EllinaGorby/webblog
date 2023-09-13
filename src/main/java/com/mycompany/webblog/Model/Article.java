package com.mycompany.webblog.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String anons;
    @Column(columnDefinition = "TEXT")
    private String full_text;
    private int views;

    public Article() {
    }

    public Article(String title, String anons, String full_text) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
    }

    public void incrementOfViews(){
        this.views++;
    }
}
