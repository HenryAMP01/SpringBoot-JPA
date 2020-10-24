package com.study.jpa.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.study.jpa.model.dto.DirectorDTO;
import com.study.jpa.model.entity.Director;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DirectorMapper {

    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    DirectorDTO directorToDirectorDTO(Director director);

    default List<DirectorDTO> directorListToDirectorListDTO(List<Director> directors){

        if(directors == null){
            return new ArrayList<>();
        }

        return directors.stream().map(this::directorToDirectorDTO).collect(Collectors.toList());
    }
    
}