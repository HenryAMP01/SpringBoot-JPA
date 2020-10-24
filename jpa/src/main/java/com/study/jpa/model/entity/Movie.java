package com.study.jpa.model.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    @Column(unique = true, nullable = false)
    private String movieId;

    @Column(nullable = false)
    private Instant createAt;

    @Column(nullable = false)
    private Instant updateAt;

    @NotNull
    @ManyToMany
    @JoinTable(name = "movie_category", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @NotNull
    @ManyToMany
    @JoinTable(name = "movie_director", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "director_id"))
    private Set<Director> directors;

    public Movie() {
        this.createAt = Instant.now();
        this.updateAt = Instant.now();
    }

    public Movie(Long id, String name, String movieId, Set<Category> categories,
            Set<Director> directors) {
        this.id = id;
        this.name = name.trim().toUpperCase();
        this.createAt = Instant.now();
        this.updateAt = Instant.now();
        this.movieId = movieId.trim();
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
        this.name = name.trim().toUpperCase();
    }

    public Instant getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public Instant getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public String getMovieId() {
        return this.movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId.trim();
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Director> getDirectors() {
        return this.directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name)
                && Objects.equals(createAt, movie.createAt) && Objects.equals(updateAt, movie.updateAt)
                && Objects.equals(movieId, movie.movieId) && Objects.equals(categories, movie.categories)
                && Objects.equals(directors, movie.directors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createAt, updateAt, movieId, categories, directors);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", createAt='" + getCreateAt() + "'"
                + ", updateAt='" + getUpdateAt() + "'" + ", movieId='" + getMovieId() + "'" + ", categories='"
                + getCategories() + "'" + ", directors='" + getDirectors() + "'" + "}";
    }

}
