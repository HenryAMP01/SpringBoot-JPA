package com.study.jpa.model.controller;

import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

import com.study.jpa.model.dto.MovieDTO;
import com.study.jpa.model.entity.Movie;
import com.study.jpa.model.mapper.MovieMapper;
import com.study.jpa.model.service.IMovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/movies")
@RestController
@CrossOrigin("*")
public class MovieController {

    @Autowired private IMovieService movieService;

    @Autowired private MovieMapper movieMapper;

    @GetMapping
    public List<MovieDTO> findAllMovies(){
        return movieMapper.movieListToMovieListDTO(movieService.findAllMovies());
    }

    @GetMapping("/{id}")
    public MovieDTO findByMovieId(@PathVariable Long id){
        return movieMapper.movieToMovieDTO(movieService.findByMovieId(id));
    }

    @PostMapping
    public MovieDTO saveMovie(@Valid @RequestBody Movie movie) {
        return movieMapper.movieToMovieDTO(movieService.saveMovie(movie));
    }

    @PutMapping("/{id}")
    public MovieDTO updateMovie(@Valid @RequestBody Movie movie, @PathVariable Long id ) {
        
        Movie movieFound = movieService.findByMovieId(id);

        if(movieFound != null){
            //movieFound.setId(movie.getId());
            movieFound.setMovieId(movie.getMovieId());
            movieFound.setName(movie.getName());
            movieFound.setCategories(movie.getCategories());
            movieFound.setDirectors(movie.getDirectors());
            //movieFound.setCreateAt(movie.getCreateAt());
            movieFound.setUpdateAt(Instant.now());

            movieService.saveMovie(movieFound);
            
        }

        return movieMapper.movieToMovieDTO(movieFound);
    }
    
    @DeleteMapping("/{id}")
    public void deleteByMovieId(@PathVariable Long id){
        movieService.deleteByMovieId(id);
    }
    
}
