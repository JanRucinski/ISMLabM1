package com.example.com_rucinski.aspects;

import com.example.model.EventDTO;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Aspect
@Component
public class StatisticsAspect {

    private AtomicInteger getAllEventsCallCount = new AtomicInteger(0);
    private AtomicLong totalEventsRetrievedCount = new AtomicLong(0);

    @Pointcut("execution(* com.example.com_rucinski.service.EventService.getAllEvents(..))")
    public void getAllEventsPointcut() {}

    @AfterReturning(pointcut = "getAllEventsPointcut()", returning = "result")
    public void afterReturningGetAllEvents(List<EventDTO> result) {

        getAllEventsCallCount.incrementAndGet();
        totalEventsRetrievedCount.addAndGet(result.size());
    }


    public int getGetAllEventsCallCount() {
        return getAllEventsCallCount.get();
    }
    public long getTotalEventsRetrievedCount() { return totalEventsRetrievedCount.get(); }
}

