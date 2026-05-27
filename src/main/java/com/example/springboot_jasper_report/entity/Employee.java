package com.example.springboot_jasper_report.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    @SequenceGenerator(
            name = "emp_seq",
            sequenceName = "employee_seq",
            allocationSize = 1
    )
    private Integer id;

    private String name;
    private String designation;
    private Double salary;
    private String doj;
}