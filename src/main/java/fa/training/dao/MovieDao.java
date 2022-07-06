package fa.training.dao;

import java.util.List;

import fa.training.entities.Movie;

public interface MovieDao {
	List<Movie> findAll();
    Movie findById(String id);
    void save(Movie movie);
    void saveAll(List<Movie> movies);
    void delete(String id);
}
