package com.study.jpa.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoryDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String categoryId;
    private String name;

    public CategoryDTO(){}

    public CategoryDTO(Long id, String categoryId, String name) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
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
        this.categoryId = categoryId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CategoryDTO)) {
            return false;
        }
        CategoryDTO categoryDTO = (CategoryDTO) o;
        return Objects.equals(id, categoryDTO.id) && Objects.equals(categoryId, categoryDTO.categoryId) && Objects.equals(name, categoryDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, name);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", categoryId='" + getCategoryId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
    
    
}