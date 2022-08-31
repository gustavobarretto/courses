package com.digitalhouse.mspost.application.rest.controllers;

import com.digitalhouse.mspost.domain.models.Editor;
import com.digitalhouse.mspost.infrastructure.services.EditorServiceAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/editor")
public class EditorController {

    private final EditorServiceAPI service;

    @PostMapping("/save")
    public ResponseEntity<Editor> save(@RequestBody Editor editor) {

        var editorDB = service.save(editor);

        return ResponseEntity.created(URI.create("/api/v1/editor/".concat(String.valueOf(editorDB.getIdEditor()))))
                .contentType(MediaType.APPLICATION_JSON)
                .body(editorDB);
    }


}
