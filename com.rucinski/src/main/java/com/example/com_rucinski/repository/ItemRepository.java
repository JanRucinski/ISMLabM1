package com.murad.sh.carbootsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.murad.sh.carbootsale.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}