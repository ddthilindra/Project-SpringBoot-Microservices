package com.deshitha.departmentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

// getters setters and constructors
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // auto increment
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
