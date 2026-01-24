package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.BookCategory;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity    // it represents that this class is entity or model class which is directly creating the database table
@Table(name = "book")    // it will create a table inside database
@Data    // it will add getters and setters
public class Book {

    @Id    // it is the primary key of the table - it will be unique and it is not null
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "publisher_name", nullable = false)
    private String publisherName;

    @Column(name = "published_date", nullable = false)
    private String publishedDate;

    @Column(name = "category", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BookCategory category;

    @Column(name = "pages", nullable = false)
    private int pages;

    @Column(name = "rack_no", nullable = false)
    private String rackNo;

    @Column(name = "total_copies", nullable = false)
    private int totalCopies;

    @Column(name = "available_copies", nullable = false)
    private int availableCopies;

    @JoinColumn
    @ManyToOne
    private Card card;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;
}
