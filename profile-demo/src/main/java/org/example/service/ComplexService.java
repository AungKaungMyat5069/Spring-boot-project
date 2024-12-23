package org.example.service;

import org.example.format.ReportFormatted;
import org.example.report.ReportProvider;
import org.example.repositary.ReportRepository;
import org.springframework.stereotype.Component;

@Component
public class ComplexService {

    private final ReportProvider reportProvider;
    private final ReportFormatted reportFormatted;
    private final ReportRepository reportRepository;

    public ComplexService(ReportProvider reportProvider, ReportFormatted reportFormatted, ReportRepository reportRepository) {
        this.reportProvider = reportProvider;
        this.reportFormatted = reportFormatted;
        this.reportRepository = reportRepository;
    }

    public void doAction() {
        reportRepository.save(reportFormatted.formatReport(reportProvider.reportProvider()));
    }


}
