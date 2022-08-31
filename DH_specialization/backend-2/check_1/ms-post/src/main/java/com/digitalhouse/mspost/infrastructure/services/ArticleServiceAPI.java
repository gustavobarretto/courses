package com.digitalhouse.mspost.infrastructure.services;

import com.digitalhouse.mspost.domain.models.Article;
import com.digitalhouse.mspost.domain.models.Editor;
import com.digitalhouse.mspost.infrastructure.shared.GenericServiceAPI;

import java.util.List;

public interface ArticleServiceAPI extends GenericServiceAPI<Article, String> {
    List<Article> findAllByEditor(Editor editor);
}
