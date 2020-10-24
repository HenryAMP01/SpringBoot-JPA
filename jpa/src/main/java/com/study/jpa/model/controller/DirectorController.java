package com.study.jpa.model.controller;

import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

import com.study.jpa.model.dto.DirectorDTO;
import com.study.jpa.model.entity.Director;
import com.study.jpa.model.mapper.DirectorMapper;
import com.study.jpa.model.service.IDirectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/directors")
@RestController
@CrossOrigin("*")
public class DirectorController {

    @Autowired private IDirectorService directorService;

    @Autowired private DirectorMapper directorMapper;

    @GetMapping
    public List<DirectorDTO> findAllDirectors(){
        return directorMapper.directorListToDirectorListDTO(directorService.findAllDirectors());
    }

    @GetMapping("/{id}")
    public DirectorDTO findByDirectorId(@PathVariable Long id){
        return directorMapper.directorToDirectorDTO(directorService.findByDirectorId(id));
    }

    @PostMapping
    public DirectorDTO saveDirector(@Valid @RequestBody Director director) {
        return directorMapper.directorToDirectorDTO(directorService.saveDirector(director));
    }

    @PutMapping("/{id}")
    public DirectorDTO updateDirector(@Valid @RequestBody Director director, @PathVariable Long id ) {
        
        Director directorFound = directorService.findByDirectorId(id);

        if(directorFound != null){
            //directorFound.setId(director.getId());
            directorFound.setDirectorId(director.getDirectorId());
            directorFound.setName(director.getName());
            //directorFound.setCreateAt(director.getCreateAt());
            directorFound.setUpdateAt(Instant.now());

            directorService.saveDirector(directorFound);
        }

        return directorMapper.directorToDirectorDTO(directorFound);
    }
    
    @DeleteMapping("/{id}")
    public void deleteByDirectorId(@PathVariable Long id){
        directorService.deleteByDirectorId(id);
    }
    
}
