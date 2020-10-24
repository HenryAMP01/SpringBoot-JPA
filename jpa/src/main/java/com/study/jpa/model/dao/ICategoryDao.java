package com.study.jpa.model.dao;

import com.study.jpa.model.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Long> {

    @Modifying
    @Query(value = "DELETE FROM movie_category mc WHERE mc.category_id=:categoryId" ,nativeQuery = true)
    void deleteAllByCategoryId(@Param("categoryId") Long categoryId);
    
}
