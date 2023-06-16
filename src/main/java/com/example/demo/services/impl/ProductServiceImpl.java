package com.example.demo.services.impl;

import com.example.demo.dtos.ProductCreate;
import com.example.demo.dtos.ProductView;
import com.example.demo.dtos.SpecsCreate;
import com.example.demo.dtos.SpecsView;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.mappers.SpecsMapper;
import com.example.demo.models.Product;
import com.example.demo.models.Specs;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.SpecsRepository;
import com.example.demo.services.ProductService;
import com.example.demo.services.SpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SpecsMapper specsMapper;

    @Autowired
    private SpecsRepository specsRepository;

    @Autowired
    private SpecsService specsService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductView> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toViewList(products);
    }

    @Override
    public ProductView getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return productMapper.toView(product);
    }

    @Override
    public ProductView createProduct(ProductCreate productCreate, SpecsCreate specsCreate) {
        Product product = productMapper.toEntity(productCreate);
       // Specs specs = specsService.createSpecs(specsCreate);
       // Specs specs = specsMapper.toEntity(specsCreate);

        //product.setSpecs(specs);
        specsRepository.save(product.getSpecs());
        productRepository.save(product);
      //  ProductView productView = productMapper.toView(product);
        //productView.setSpecs(specsView);
        System.out.println("createproduct");
        return productMapper.toView(product);
    }
}
