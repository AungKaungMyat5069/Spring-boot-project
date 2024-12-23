package org.example.service;

import org.example.ds.Format;
import org.example.ds.Report;
import org.example.format.ReportFormatted;
import org.example.logger.PerformanceLogger;
import org.example.provider.ReportProvider;
import org.example.repository.ReportRepository;
import org.springframework.stereotype.Service;
import static org.example.logger.PerformanceLogger.*;

@Service
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
        PerformanceLogger logger = new PerformanceLogger();
        PerformanceLogger.PerformanceLoggerInfo info;
        info = logger.startTime("Report Provider");
        Report report = reportProvider.report();
        logger.endTime(info);
        System.out.println();

        info = logger.startTime("Report Formatted");
        Format format = reportFormatted.getFormat(report);
        logger.endTime(info);
        System.out.println();

        info = logger.startTime("Report Repository");
        reportRepository.save(format);
        logger.endTime(info);
        System.out.println();
    }

}
