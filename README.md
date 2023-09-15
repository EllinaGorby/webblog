# webblog

## 1. Einführung (Einleitung):

Ein kleines, einfaches Bildungsprojekt - ein Webblog, in dem Artikel hinzugefügt, bearbeitet und gelöscht werden können. Implementiert in Java mit dem Spring Boot-Framework.

---

## 2. Datenmodell und Datenrepository (Datenbank):

Datenmodell:
Das Datenmodell besteht aus einer Klasse namens "Article", die die Struktur und Eigenschaften der Artikel im Blog repräsentiert. Hier ist der Code dafür:

```java
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
```
Datenrepository:
Das Datenrepository ist ein Interface namens "ArticleRepository", das von "CrudRepository" erbt und den Zugriff auf die Artikeldaten ermöglicht. Hier ist der Code dafür:

```java
package com.mycompany.webblog.repository;

import com.mycompany.webblog.Model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
```
---
## 3. Datenbankverbindung (Datenbankverwaltung):

Die Anwendung verwendet eine MySQL-Datenbank zur Speicherung von Blog-Artikeln und anderen Daten. Die Konfigurationsparameter für die Datenbankverbindung sind in der Datei "application.properties" definiert. Hier sind die relevanten Konfigurationen:
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_webblog
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.show-sql: true
#logging.level.root = DEBUG
```

- **spring.jpa.hibernate.ddl-auto**: Diese Einstellung legt fest, wie Hibernate (ein ORM-Framework) mit der Datenbankstruktur umgeht. Im aktuellen Fall ist "update" ausgewählt, was bedeutet, dass Hibernate die Datenbank automatisch aktualisiert, wenn sich das Datenmodell ändert. Dies ist nützlich während der Entwicklung.

- **spring.datasource.url**: Hier wird die JDBC-URL für die Verbindung zur MySQL-Datenbank angegeben. Standardmäßig ist der Host auf "localhost" und der Port auf "3306" eingestellt, und die Datenbank mit dem Namen "db_webblog" wird verwendet.

- **spring.datasource.username und spring.datasource.password**: Dies sind die Anmeldeinformationen für die Datenbank. Im Beispiel sind sie auf den MySQL-Benutzer "root" und ein leeres Passwort eingestellt. Bitte ändern Sie diese Werte entsprechend Ihrer Datenbankkonfiguration.

- **spring.datasource.driver-class-name**: Dies ist der Name des JDBC-Treibers für MySQL.

---
## 4. Controller (Steuerung):

Hier sind die Controller für die Steuerung des Webblogs:

**"BlogController"** verwaltet die Anzeige und Verwaltung der Blog-Artikel.

**"MainController"** behandelt die Hauptseite und die "Über uns"-Seite.

---
## 5. Verwendete Bibliotheken und Frameworks:

Hier sind die Bibliotheken und Frameworks aufgeführt, die im Projekt verwendet wurden. Zu den Hauptkomponenten gehören Spring Boot, Thymeleaf und Bootstrap.

---

## 6. Benutzeroberfläche (Nutzerinterface):

`http://localhost:8080/`

Startseite:

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



