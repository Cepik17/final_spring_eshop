package com.example.demo.services;

import com.example.demo.dtos.SpecsCreate;
import com.example.demo.dtos.SpecsView;
import com.example.demo.models.Specs;

public interface SpecsService {

    Specs createSpecs(SpecsCreate specsCreate);
}
