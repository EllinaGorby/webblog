package com.mycompany.webblog.repository;

import com.mycompany.webblog.Model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
