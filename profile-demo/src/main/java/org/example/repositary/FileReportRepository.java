package org.example.repositary;

import org.example.ds.ReportFormat;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("file")
public class FileReportRepository implements ReportRepository {
    @Override
    public void save(ReportFormat reportFormat) {
        System.out.println("Saving report for ");
    }
}
