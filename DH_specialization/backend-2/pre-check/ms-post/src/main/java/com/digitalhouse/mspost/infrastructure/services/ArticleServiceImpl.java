package com.digitalhouse.mspost.infrastructure.services;

import com.digitalhouse.mspost.domain.models.Article;
import com.digitalhouse.mspost.domain.models.Editor;
import com.digitalhouse.mspost.domain.repositories.ArticleRepository;
import com.digitalhouse.mspost.infrastructure.shared.GenericServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends GenericServiceImpl<Article, String> implements ArticleServiceAPI {

    private final ArticleRepository repository;


    @Override
    public JpaRepository<Article, String> getJpaRepository() {
        return repository;
    }

    @Override
    public List<Article> findAllByEditor(Editor editor) {
        return repository.findAllByEditor(editor);
    }
}
