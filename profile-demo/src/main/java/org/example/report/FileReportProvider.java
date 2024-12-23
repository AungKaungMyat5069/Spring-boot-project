package org.example.report;

import org.example.ds.Report;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("file")
public class FileReportProvider implements ReportProvider {

    @Override
    public Report reportProvider() {
        System.out.println("Report provided by FileReportProvider");
        return new Report();
    }
}
