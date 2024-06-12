package com.hutech.baitapgiuaky.service;


import com.hutech.baitapgiuaky.entities.Book;
import com.hutech.baitapgiuaky.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(UUID id);

    Book save(Book book);

    void deleteById(UUID id);
}
