package com.example.catalogservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	private Long id;

	private String name;

	private String genre;

	private String urlStream;
}
