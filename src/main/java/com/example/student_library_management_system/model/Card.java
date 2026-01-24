package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity    // it represents that this class is entity or model class which is directly creating the database table
@Table(name = "card")     // it will create a table inside database
@Data    // it will add getters and setters
@AllArgsConstructor    // parameterized constructor
@NoArgsConstructor    // default constructor
public class Card {

    @Id    // it is the primary key of the table - it will be unique and it is not null
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @Column(name = "card_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @Column(name = "expiry_date", nullable = false)
    private String expiryDate;

    @Column(name = "created_date", nullable = false)
    @CreationTimestamp    // when a new card is created/issued it will automatically add date and time of the system
    private Date createdDate;

    @Column(name = "updated_date", nullable = false)
    @UpdateTimestamp    // when a card is updated it will automatically add date and time of the system
    private Date updatedDate;

    @Column(name = "max_books_allowed", nullable = false)
    private int maxBooksAllowed;

    @JoinColumn    // it joins the primary key(student id) of student table as a foreign key in card table
    @OneToOne    // one card will be assigned to one student
    private Student student;

    @OneToMany(mappedBy = "card")
    private List<Book> bookList;

    @OneToMany(mappedBy = "card")
    private List<Transaction> transactionList;
}
