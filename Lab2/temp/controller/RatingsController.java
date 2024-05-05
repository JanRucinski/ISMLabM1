package com.example.com_rucinski.controller;

import com.murad.sh.api.RatingsApi;
import com.murad.sh.carbootsale.service.RatingService;
import com.murad.sh.model.RateSaleEvent201Response;
import com.murad.sh.model.RatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class RatingsController implements RatingsApi {

    @Autowired
    private RatingService ratingService;

    @Override
    public ResponseEntity<List<RatingDTO>> getRatingsForEvent(Long eventId) {
        List<RatingDTO> ratings = ratingService.getRatingForEvent(eventId);
        if (ratings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<RateSaleEvent201Response> rateSaleEvent(Long eventId, RatingDTO ratingDTO) {
        RatingDTO createdRating = ratingService.addRatingForEvent(eventId, ratingDTO);
        if (createdRating == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        RateSaleEvent201Response response = new RateSaleEvent201Response();
        response.setRatingId(createdRating.getRatingId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
