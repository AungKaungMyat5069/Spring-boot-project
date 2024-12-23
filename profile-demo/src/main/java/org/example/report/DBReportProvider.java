package org.example.report;

import org.example.ds.Report;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("db")
public class DBReportProvider implements ReportProvider {
    @Override
    public Report reportProvider() {
        System.out.println("DB Report Provider");

        return new Report();
    }
}
