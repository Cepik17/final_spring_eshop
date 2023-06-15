package com.example.demo.repositories;

import com.example.demo.models.Specs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecsRepository extends JpaRepository<Specs, Long> {
}
