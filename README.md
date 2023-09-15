# webblog

## 1. Einführung (Einleitung):
Ein kleines, einfaches Bildungsprojekt - ein Webblog, in dem Artikel hinzugefügt, bearbeitet und gelöscht werden können. Implementiert in Java mit dem Spring Boot-Framework.
---

## 2. Datenmodell und Datenrepository (Datenbank):

Datenmodell:
Das Datenmodell besteht aus einer Klasse namens "Article", die die Struktur und Eigenschaften der Artikel im Blog repräsentiert. Hier ist der Code dafür:

\```
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

    // Konstruktoren und Methoden hier...
}
\```
Datenrepository:
Das Datenrepository ist ein Interface namens "ArticleRepository", das von "CrudRepository" erbt und den Zugriff auf die Artikeldaten ermöglicht. Hier ist der Code dafür:

\```
package com.mycompany.webblog.repository;

import com.mycompany.webblog.Model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
\```
---
## 3. Controller (Steuerung):

Hier sind die Controller für die Steuerung des Webblogs:

"BlogController" verwaltet die Anzeige und Verwaltung der Blog-Artikel.
"MainController" behandelt die Hauptseite und die "Über uns"-Seite.

---
# 5. Verwendete Bibliotheken und Frameworks:

Hier sind die Bibliotheken und Frameworks aufgeführt, die im Projekt verwendet wurden. Zu den Hauptkomponenten gehören Spring Boot, Thymeleaf und Bootstrap.
---

## 5. Benutzeroberfläche (Nutzerinterface):
Beim 

`http://localhost:8080/`

sehen wir Startseite:

![homepage](https://github.com/EllinaGorby/webblog/blob/master/screenshots/homepage.jpg)

![link_blog](https://github.com/EllinaGorby/webblog/blob/master/screenshots/link_blog.jpg)

![blog](https://github.com/EllinaGorby/webblog/blob/master/screenshots/articles.jpg)

![articles_button_more](https://github.com/EllinaGorby/webblog/blob/master/screenshots/articles_button_more.jpg)

![review_article](https://github.com/EllinaGorby/webblog/blob/master/screenshots/review_article.jpg)

Jeder Artikel kann 
- **bearbeitet**
- **gelöscht**
  
werden und Sie können sehen, wie viele Aufrufe der Artikel hatte.
- **view**

![blog](https://github.com/EllinaGorby/webblog/blob/master/screenshots/review_article_buttons.jpg)

Nach dem Taste **edit**:

![edit_article](https://github.com/EllinaGorby/webblog/blob/master/screenshots/edit_article.jpg)


![edit_article_button_save](https://github.com/EllinaGorby/webblog/blob/master/screenshots/edit_article_button_save.jpg)

Möglichkeit, einen Artikel hinzuzufügen:

![link_add_article](https://github.com/EllinaGorby/webblog/blob/master/screenshots/link_add_article.jpg)


![add_articles](https://github.com/EllinaGorby/webblog/blob/master/screenshots/add_articles.jpg)



