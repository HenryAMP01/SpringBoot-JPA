package com.study.jpa.model.mapper;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.study.jpa.model.dto.MovieDTO;
import com.study.jpa.model.entity.Movie;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDTO movieToMovieDTO(Movie movie);

    default List<MovieDTO> movieListToMovieListDTO(List<Movie> movies) {

        if (movies == null) {
            return new ArrayList<>();
        }

        return movies.stream().map(this::movieToMovieDTO).collect(Collectors.toList());

    }

    default String fromInstantToString(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

}
