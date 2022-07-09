package com.example.movieservice.domain.data;

import com.example.movieservice.domain.model.Movie;
import com.example.movieservice.domain.repository.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

	private MovieRepository repository;

	public DataLoader (MovieRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run (ApplicationArguments args) throws Exception {
		repository.save(new Movie(1L, "filme", "terror", "what"));
		repository.save(new Movie(2L, "borboleta", "terror", "what"));
		repository.save(new Movie(3L, "adedonha", "terror", "what"));
		repository.save(new Movie(4L, "pajero", "terror", "what"));
		repository.save(new Movie(5L, "dakar", "acao", "what"));
		repository.save(new Movie(6L, "shadow", "acao", "what"));
		repository.save(new Movie(7L, "boné", "romance", "what"));
		repository.save(new Movie(8L, "xícara", "romance", "what"));
	}
}
