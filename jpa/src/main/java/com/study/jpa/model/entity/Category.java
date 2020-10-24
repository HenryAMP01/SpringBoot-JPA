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
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    @Column(unique = true, nullable = false)
    private String categoryId;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Instant createAt;

    @Column(nullable = false)
    private Instant updateAt;

    public Category() {
        this.createAt = Instant.now();
        this.updateAt = Instant.now();
    }

    public Category(Long id, String categoryId, String name) {
        this.id = id;
        this.categoryId = categoryId.trim();
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

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId.trim();
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
        if (!(o instanceof Category)) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(categoryId, category.categoryId)
                && Objects.equals(name, category.name) && Objects.equals(createAt, category.createAt)
                && Objects.equals(updateAt, category.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, name, createAt, updateAt);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", categoryId='" + getCategoryId() + "'" + ", name='" + getName() + "'"
                + ", createAt='" + getCreateAt() + "'" + ", updateAt='" + getUpdateAt() + "'" + "}";
    }

}
