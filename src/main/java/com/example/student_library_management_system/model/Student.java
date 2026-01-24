package com.example.student_library_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity    // it represents that this class is entity or model class which is directly creating the database table
@Table(name = "student")    // it will create a table inside database
@Data    // it will add getters and setters
@AllArgsConstructor    // parameterized constructor
@NoArgsConstructor    // default constructor
public class Student {

    @Id    // it is the primary key of the table - it will be unique and it is not null
    @Column(name = "student_id")    // it will create a column inside database table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "student_name", nullable = false)    // nullable = false - it cannot contain null value
    private String studentName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "semester", nullable = false)
    private int semester;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "dept", nullable = false)
    private String dept;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;
}
