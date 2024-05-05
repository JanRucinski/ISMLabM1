package com.example.com_rucinski.repository;

import com.murad.sh.carbootsale.model.SaleEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleEventRepository extends JpaRepository<SaleEvent, Long> {
}