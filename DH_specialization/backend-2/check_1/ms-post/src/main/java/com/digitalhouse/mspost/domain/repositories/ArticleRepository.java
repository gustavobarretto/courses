package com.digitalhouse.mspost.domain.repositories;

import com.digitalhouse.mspost.domain.models.Article;
import com.digitalhouse.mspost.domain.models.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, String> {

    List<Article> findAllByEditor(Editor editor);
}
