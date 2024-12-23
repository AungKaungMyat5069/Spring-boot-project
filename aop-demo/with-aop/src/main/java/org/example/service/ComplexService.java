package org.example.service;

import org.example.ds.Format;
import org.example.ds.Report;
import org.example.format.ReportFormatted;
import org.example.provider.ReportProvider;
import org.example.repository.ReportRepository;
import org.springframework.stereotype.Service;


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

        Report report = reportProvider.report();
        System.out.println();

        Format format = reportFormatted.getFormat(report);
        System.out.println();

        reportRepository.save(format);
        System.out.println();
    }

}
