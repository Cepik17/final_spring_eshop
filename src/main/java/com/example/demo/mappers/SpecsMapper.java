package com.example.demo.mappers;

import com.example.demo.dtos.SpecsCreate;
import com.example.demo.dtos.SpecsView;
import com.example.demo.models.Specs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecsMapper {

    Specs toEntity(SpecsCreate specsCreate);

    SpecsView toView(Specs specs);

    SpecsCreate toCreate(Specs specs);
}
