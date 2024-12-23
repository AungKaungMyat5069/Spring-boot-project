package org.example.provider;

import org.example.aspect.PerformanceAspectAnnotation;
import org.example.ds.Report;
import org.springframework.stereotype.Component;

@Component
public class ReportProviderImpl implements ReportProvider{

    @PerformanceAspectAnnotation
    @Override
    public Report report() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ReportProviderImpl report");
        return new Report();
    }
}
