package com.study.jpa.model.service;

import java.util.List;

import com.study.jpa.model.entity.Movie;

public interface IMovieService {

    public Movie findByMovieId(Long id);

    public List<Movie> findAllMovies();

    public Movie saveMovie(Movie movie);

    public void deleteByMovieId(Long id);

}
