package org.example.format;

import org.example.ds.Report;
import org.example.ds.ReportFormat;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("file")
public class FileReportFormatted implements ReportFormatted {

    @Override
    public ReportFormat formatReport(Report report) {
        System.out.println("File Report Formatted ");
        return new ReportFormat();
    }
}
