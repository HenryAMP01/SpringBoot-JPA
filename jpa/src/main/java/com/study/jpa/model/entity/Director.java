package com.study.jpa.model.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Director implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 2)
    @Column(nullable = false)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    @Column(unique = true, nullable = false)
    private String directorId;

    @Column(nullable = false)
    private Instant createAt;

    @Column(nullable = false)
    private Instant updateAt;

    public Director() {
        this.createAt = Instant.now();
        this.updateAt = Instant.now();
    }

    public Director(Long id, String directorId, String name) {
        this.id = id;
        this.directorId = directorId.trim();
        this.name = name.trim().toUpperCase();
        this.createAt = Instant.now();
        this.updateAt = Instant.now();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirectorId() {
        return this.directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId.trim();
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


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Director)) {
            return false;
        }
        Director director = (Director) o;
        return Objects.equals(id, director.id) && Objects.equals(directorId, director.directorId) && Objects.equals(name, director.name) && Objects.equals(createAt, director.createAt) && Objects.equals(updateAt, director.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, directorId, name, createAt, updateAt);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", code='" + getDirectorId() + "'" +
            ", name='" + getName() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", updateAt='" + getUpdateAt() + "'" +
            "}";
    }

    
}