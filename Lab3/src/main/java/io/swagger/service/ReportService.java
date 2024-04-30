package io.swagger.service;

import io.swagger.model.InlineResponse200;

public interface ReportService {
    InlineResponse200 reportsGet();

    Object getReport();
}
