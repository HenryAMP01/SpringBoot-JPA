package com.study.jpa.model.service;

import java.util.List;

import com.study.jpa.model.entity.Category;

public interface ICategoryService {

    public Category findByCategoryId(Long id);

    public List<Category> findAllCategories();

    public Category saveCategory(Category category);

    public void deleteByCategoryId(Long id);

}
