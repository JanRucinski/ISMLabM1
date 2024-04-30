package io.swagger.service;

import io.swagger.model.InlineResponse200;
import io.swagger.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReportServiceImplementation implements io.swagger.service.ReportService{
    @Autowired
    private io.swagger.repository.ReportRepository reportRepository;
    public void createReport(Report report){
        Report report1 = report;
        reportRepository.save(report);
    }

    @Override
    public InlineResponse200 reportsGet() {
        return null;
    }

    @Override
    public Object getReport() {
        return null;
    }
}
