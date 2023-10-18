package com.example.orderdemo.repository;

import com.example.orderdemo.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findById(UUID id);

    void deleteById(UUID id);
}
