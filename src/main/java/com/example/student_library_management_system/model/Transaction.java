package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity    // it represents that this class is entity or model class which is directly creating the database table
@Table(name = "transaction")    // it will create a table inside database
@Data    // it will add getters and setters
public class Transaction {

    @Id    // it is the primary key of the table - it will be unique and it is not null
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @Column(name = "issue_date", nullable = false)
    @CreationTimestamp
    private Date issueDate;

    @Column(name = "due_date", nullable = false)
    private String dueDate;

    @Column(name = "return_date", nullable = false)
    private String returnDate;

    @Column(name = "transaction_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @JoinColumn
    @ManyToOne
    private Card card;

    @JoinColumn
    @ManyToOne
    private Book book;
}
