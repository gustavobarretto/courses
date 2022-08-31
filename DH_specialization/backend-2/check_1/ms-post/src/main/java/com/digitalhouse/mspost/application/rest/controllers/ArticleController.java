package com.digitalhouse.mspost.application.rest.controllers;

import com.digitalhouse.mspost.domain.models.Article;
import com.digitalhouse.mspost.infrastructure.services.ArticleServiceAPI;
import com.digitalhouse.mspost.infrastructure.services.EditorServiceAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleServiceAPI articleService;
    private final EditorServiceAPI editorService;

    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Article> save(@RequestBody Article article) {

        var articleDB = articleService.save(article);

        return ResponseEntity.created(URI.create("/api/v1/post/".concat(String.valueOf(articleDB.getIdArticle()))))
                .contentType(MediaType.APPLICATION_JSON)
                .body(articleDB);
    }

    @GetMapping("/find/{idEditor}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Article>> find(@PathVariable("idEditor") Long idEditor) {
        var editorDB = editorService.getOne(idEditor);
        if (editorDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(articleService.findAllByEditor(editorDB));
    }

}
