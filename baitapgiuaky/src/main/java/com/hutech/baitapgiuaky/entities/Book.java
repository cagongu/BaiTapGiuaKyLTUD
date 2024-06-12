package com.hutech.baitapgiuaky.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "room_id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID book_id;

    private String title;
    private String author;
    private String publisher;
    private Double price;

}
