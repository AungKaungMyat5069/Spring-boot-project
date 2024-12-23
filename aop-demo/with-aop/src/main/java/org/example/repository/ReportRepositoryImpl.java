package org.example.repository;

import org.example.aspect.PerformanceAspectAnnotation;
import org.example.ds.Format;
import org.springframework.stereotype.Component;

@Component
public class ReportRepositoryImpl implements ReportRepository{


    @PerformanceAspectAnnotation
    @Override
    public void save(Format format) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("save " + format);
    }
}
