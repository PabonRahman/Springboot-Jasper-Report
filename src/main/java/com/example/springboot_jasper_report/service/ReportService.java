package com.example.springboot_jasper_report.service;

import com.example.springboot_jasper_report.entity.Employee;
import com.example.springboot_jasper_report.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final EmployeeRepository repository;

    public String generateReport(String format) {
        try {
            List<Employee> employees = repository.findAll();

            if (employees.isEmpty()) {
                return "No employees found";
            }

            File file = new File("src/main/resources/reports/employees.jrxml");
            JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), dataSource);

            if (format.equalsIgnoreCase("pdf")) {
                String outputPath = System.getProperty("user.dir") + "/employees.pdf";
                JasperExportManager.exportReportToPdfFile(print, outputPath);
                return "PDF generated: " + outputPath;
            }

            return "Report generated";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}