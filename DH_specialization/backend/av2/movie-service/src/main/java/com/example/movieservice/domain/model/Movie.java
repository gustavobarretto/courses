package com.example.movieservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Basic (fetch = FetchType.LAZY)
	private String genre;

	@Basic (fetch = FetchType.LAZY)
	private String urlStream;

}
