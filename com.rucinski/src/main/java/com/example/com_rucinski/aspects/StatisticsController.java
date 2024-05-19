package com.example.com_rucinski.aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    @Autowired
    private StatisticsAspect statisticsAspect;

    @GetMapping("/api/statistics")
    public ResponseEntity getStatistics() {
        return ResponseEntity.ok(statisticsAspect.getGetAllEventsCallCount());
    }
}

class StatisticsDTO {
    private int getAllEventsCallCount;

    public StatisticsDTO(int getAllEventsCallCount) {
        this.getAllEventsCallCount = getAllEventsCallCount;
    }
}