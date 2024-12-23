package org.example.format;

import org.example.ds.Report;
import org.example.ds.ReportFormat;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("db")
public class DBReportFormatted implements ReportFormatted{

    @Override
    public ReportFormat formatReport(Report report) {
        System.out.println("DB Report Formatted " );
        return new ReportFormat();
    }
}
