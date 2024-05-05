package com.example.com_rucinski.repository;

import com.example.com_rucinski.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}