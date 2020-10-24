package com.study.jpa.model.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class MovieDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String movieId;
    private String createAt;
    private String updateAt;

    private Set<CategoryDTO> categories;
    private Set<DirectorDTO> directors;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String name, String movieId, String createAt, String updateAt, Set<CategoryDTO> categories,
            Set<DirectorDTO> directors) {
        this.id = id;
        this.name = name;
        this.movieId = movieId;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.categories = categories;
        this.directors = directors;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieId() {
        return this.movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public Set<CategoryDTO> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    public Set<DirectorDTO> getDirectors() {
        return this.directors;
    }

    public void setDirectors(Set<DirectorDTO> directors) {
        this.directors = directors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MovieDTO)) {
            return false;
        }
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(id, movieDTO.id) && Objects.equals(name, movieDTO.name)
                && Objects.equals(movieId, movieDTO.movieId) && Objects.equals(createAt, movieDTO.createAt)
                && Objects.equals(updateAt, movieDTO.updateAt) && Objects.equals(categories, movieDTO.categories)
                && Objects.equals(directors, movieDTO.directors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, movieId, createAt, updateAt, categories, directors);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", movieId='" + getMovieId() + "'"
                + ", createAt='" + getCreateAt() + "'" + ", updateAt='" + getUpdateAt() + "'" + ", categories='"
                + getCategories() + "'" + ", directors='" + getDirectors() + "'" + "}";
    }

}
