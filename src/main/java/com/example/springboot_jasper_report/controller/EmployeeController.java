package com.example.springboot_jasper_report.controller;

import com.example.springboot_jasper_report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class EmployeeController {

    private final ReportService service;

    @GetMapping("/{format}")
    public String generate(@PathVariable String format) {
        return service.generateReport(format);
    }
}