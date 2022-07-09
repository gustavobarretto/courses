package com.example.movieservice.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

	@Value("${mensagem}")
	private String mensagem;

	@RequestMapping("/mensagem")
	ResponseEntity<String> getMensagem() {
		return ResponseEntity.ok().body(this.mensagem);
	}
}
