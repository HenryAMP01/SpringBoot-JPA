package com.study.jpa.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.study.jpa.model.dto.CategoryDTO;
import com.study.jpa.model.entity.Category;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

    default List<CategoryDTO> categoryListToCategoryListDTO(List<Category> categories){

        if(categories == null){
            return new ArrayList<>();
        }

        return categories.stream().map(this::categoryToCategoryDTO).collect(Collectors.toList());
    }
    
}
