package com.example.demo.services.impl;

import com.example.demo.dtos.SpecsCreate;
import com.example.demo.dtos.SpecsView;
import com.example.demo.mappers.SpecsMapper;
import com.example.demo.models.Specs;
import com.example.demo.repositories.SpecsRepository;
import com.example.demo.services.SpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecsServiceImpl implements SpecsService {

    @Autowired
    private SpecsRepository specsRepository;

    @Autowired
    private SpecsMapper specsMapper;

    @Override
    public Specs createSpecs(SpecsCreate specsCreate) {
        Specs specs = specsMapper.toEntity(specsCreate);
        specsRepository.save(specs);
        System.out.println("specs");
        return specs;
    }
}
