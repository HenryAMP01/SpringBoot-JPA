package com.study.jpa.model.dao;

import com.study.jpa.model.entity.Director;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDirectorDao extends JpaRepository<Director, Long> {

    @Modifying
    @Query(value = "DELETE FROM movie_director mc WHERE mc.director_id=:directorId" ,nativeQuery = true)
    void deleteAllByDirectorId(@Param("directorId") Long directorId);
    
}
