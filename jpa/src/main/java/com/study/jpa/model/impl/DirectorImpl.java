package com.study.jpa.model.impl;

import java.util.List;

import com.study.jpa.model.dao.IDirectorDao;
import com.study.jpa.model.entity.Director;
import com.study.jpa.model.service.IDirectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DirectorImpl implements IDirectorService {

    @Autowired private IDirectorDao directorDao;

    @Override
    @Transactional(readOnly = true)
    public Director findByDirectorId(Long id) {
        return directorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Director> findAllDirectors() {
        return directorDao.findAll();
    }

    @Override
    @Transactional
    public Director saveDirector(Director director) {
        return directorDao.save(director);
    }

    @Override
    @Transactional
    public void deleteByDirectorId(Long id) {
        
        directorDao.deleteAllByDirectorId(id);
        directorDao.deleteById(id);

    }

    
}