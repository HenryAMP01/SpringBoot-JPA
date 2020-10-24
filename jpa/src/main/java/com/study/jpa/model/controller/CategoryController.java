package com.study.jpa.model.controller;

import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

import com.study.jpa.model.dto.CategoryDTO;
import com.study.jpa.model.entity.Category;
import com.study.jpa.model.mapper.CategoryMapper;
import com.study.jpa.model.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RequestMapping("/api/categories")
@RestController
@CrossOrigin("*")
public class CategoryController {

    @Autowired private ICategoryService categoryService;

    @Autowired private CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDTO> findAllCategories(){
        return categoryMapper.categoryListToCategoryListDTO(categoryService.findAllCategories());
    }

    @GetMapping("/{id}")
    public CategoryDTO findByCategoryId(@PathVariable Long id){
        return categoryMapper.categoryToCategoryDTO(categoryService.findByCategoryId(id));
    }

    @PostMapping
    public CategoryDTO saveCategory(@Valid @RequestBody Category category) {
        return categoryMapper.categoryToCategoryDTO(categoryService.saveCategory(category));
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@Valid @RequestBody Category category, @PathVariable Long id ) {
        
        Category categoryFound = categoryService.findByCategoryId(id);

        if(categoryFound != null){
            //categoryFound.setId(category.getId());
            categoryFound.setCategoryId(category.getCategoryId());
            categoryFound.setName(category.getName());
            //categoryFound.setCreateAt(category.getCreateAt());
            categoryFound.setUpdateAt(Instant.now());

            categoryService.saveCategory(categoryFound);
        }

        return categoryMapper.categoryToCategoryDTO(categoryFound);
    }
    
    @DeleteMapping("/{id}")
    public void deleteByCategoryId(@PathVariable Long id){
        categoryService.deleteByCategoryId(id);
    }
    
}
