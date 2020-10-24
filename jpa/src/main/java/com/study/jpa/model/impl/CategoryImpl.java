package com.study.jpa.model.impl;

import java.util.List;

import com.study.jpa.model.dao.ICategoryDao;
import com.study.jpa.model.entity.Category;
import com.study.jpa.model.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryImpl implements ICategoryService {

    @Autowired private ICategoryDao categoryDao;

    @Override
    @Transactional(readOnly = true)
    public Category findByCategoryId(Long id) {
        return categoryDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    @Transactional
    public Category saveCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    @Transactional
    public void deleteByCategoryId(Long id) {
        categoryDao.deleteAllByCategoryId(id);
        categoryDao.deleteById(id);

    }

}