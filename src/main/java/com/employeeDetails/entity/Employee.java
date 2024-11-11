package com.employeeDetails.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;
    private double salary;


}
