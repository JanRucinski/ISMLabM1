package com.example.com_rucinski.aspects;

import com.example.model.EventDTO;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
public class StatisticsAspect {

    private AtomicInteger getAllEventsCallCount = new AtomicInteger(0);

    @Pointcut("execution(* com.example.com_rucinski.service.EventService.getAllEvents(..))")
    public void getAllEventsPointcut() {}

    @AfterReturning(pointcut = "getAllEventsPointcut()", returning = "result")
    public void afterReturningGetAllEvents(List<EventDTO> result) {
        getAllEventsCallCount.incrementAndGet();
    }


    public int getGetAllEventsCallCount() {
        return getAllEventsCallCount.get();
    }
}

