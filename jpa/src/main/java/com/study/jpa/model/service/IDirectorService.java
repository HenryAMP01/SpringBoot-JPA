package com.study.jpa.model.service;

import java.util.List;

import com.study.jpa.model.entity.Director;

public interface IDirectorService {

    public Director findByDirectorId(Long id);

    public List<Director> findAllDirectors();

    public Director saveDirector(Director category);

    public void deleteByDirectorId(Long id);

}
