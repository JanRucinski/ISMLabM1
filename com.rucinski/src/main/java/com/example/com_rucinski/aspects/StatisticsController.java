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
    public ResponseEntity<StatisticsDTO> getStatistics() {
        StatisticsDTO statistics = new StatisticsDTO(
                statisticsAspect.getGetAllEventsCallCount(),
                statisticsAspect.getTotalEventsRetrievedCount()
        );
        return ResponseEntity.ok(statistics);
    }
}

class StatisticsDTO {
    private int getAllEventsCallCount;
    private long totalEventsRetrievedCount;

    public StatisticsDTO(int getAllEventsCallCount, long totalEventsRetrievedCount) {
        this.getAllEventsCallCount = getAllEventsCallCount;
        this.totalEventsRetrievedCount = totalEventsRetrievedCount;
    }

    public int getGetAllEventsCallCount() {
        return getAllEventsCallCount;
    }

    public void setGetAllEventsCallCount(int getAllEventsCallCount) {
        this.getAllEventsCallCount = getAllEventsCallCount;
    }

    public long getTotalEventsRetrievedCount() {
        return totalEventsRetrievedCount;
    }

    public void setTotalEventsRetrievedCount(long totalEventsRetrievedCount) {
        this.totalEventsRetrievedCount = totalEventsRetrievedCount;
    }
}
