package com.example.com_rucinski.controller;

import com.murad.sh.api.SaleEventsApi;
import com.murad.sh.carbootsale.service.SaleEventService;
import com.murad.sh.model.CreateSaleEvent201Response;
import com.murad.sh.model.SaleEventDTO;
import com.murad.sh.model.SignUpUser201Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleEventsController implements SaleEventsApi {

    @Autowired
    private SaleEventService saleEventService;

    @Override
    public ResponseEntity<List<SaleEventDTO>> getAllSaleEvents() {
        List<SaleEventDTO> saleEventList = saleEventService.getAllSaleEvents();
        return new ResponseEntity<>(saleEventList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateSaleEvent201Response> createSaleEvent(SaleEventDTO saleEventDTO) {
        SaleEventDTO createdSaleEvent = saleEventService.createSaleEvent(saleEventDTO);
        CreateSaleEvent201Response response = new CreateSaleEvent201Response().eventId(createdSaleEvent.getEventId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SaleEventDTO> getSaleEvent(Long eventId) {
        SaleEventDTO saleEventDTO = saleEventService.getSaleEvent(eventId);
        if (saleEventDTO != null) {
            return new ResponseEntity<>(saleEventDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> registerForEvent(Long eventId, SignUpUser201Response signUpUser201Response) {
        boolean result = saleEventService.registerForEvent(eventId, signUpUser201Response.getUserId());
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteSaleEvent(Long eventId) {
        boolean result = saleEventService.deleteSaleEvent(eventId);
        if (result) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> updateSaleEvent(Long eventId, SaleEventDTO saleEventDTO) {
        SaleEventDTO updatedSaleEvent = saleEventService.updateSaleEvent(eventId, saleEventDTO);
        if (updatedSaleEvent != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
