package com.example.demo.repositories;

import com.example.demo.dtos.ProductView;
import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.isHotDeal = 'Yes'")
    List<Product> findAllHotDeals();
}
