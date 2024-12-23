package org.example.format;

import org.example.ds.Format;
import org.example.ds.Report;
import org.springframework.stereotype.Component;

@Component
public class ReportFormattedImpl implements ReportFormatted{


    @Override
    public Format getFormat(Report report) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Report Formatted Impl" + report);
        return new Format();
    }
}
