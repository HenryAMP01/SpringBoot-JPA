package com.study.jpa.model.impl;

import java.util.List;

import com.study.jpa.model.dao.IMovieDao;
import com.study.jpa.model.entity.Movie;
import com.study.jpa.model.service.IMovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieImpl implements IMovieService {

    @Autowired private IMovieDao movieDao;

    @Override
    @Transactional(readOnly = true)
    public Movie findByMovieId(Long id) {
        return movieDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAllMovies() {
        return movieDao.findAll();
    }

    @Override
    @Transactional
    public Movie saveMovie(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    @Transactional
    public void deleteByMovieId(Long id) {
        movieDao.deleteById(id);

    }
}
