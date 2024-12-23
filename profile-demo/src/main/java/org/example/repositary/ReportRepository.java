package org.example.repositary;


import org.example.ds.Report;
import org.example.ds.ReportFormat;

public interface ReportRepository {
    public void save(ReportFormat reportFormat);
}
