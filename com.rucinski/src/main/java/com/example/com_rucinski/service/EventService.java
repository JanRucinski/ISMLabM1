package com.example.com_rucinski.service;

import com.murad.sh.model.SaleEventDTO;

import java.util.List;

public interface SaleEventService {
    SaleEventDTO createSaleEvent(SaleEventDTO saleEventDTO);
    SaleEventDTO getSaleEvent(Long eventId);
    List<SaleEventDTO> getAllSaleEvents();
    SaleEventDTO updateSaleEvent(Long eventId, SaleEventDTO saleEventDTO);
    boolean deleteSaleEvent(Long eventId);
    boolean registerForEvent(Long eventId, Long userId);
}
