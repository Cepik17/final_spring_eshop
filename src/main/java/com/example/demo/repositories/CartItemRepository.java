package com.example.demo.repositories;

import com.example.demo.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {


  //  List<CartItem> findByCart_Id(Long cartId);

}
