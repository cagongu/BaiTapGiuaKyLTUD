package com.hutech.baitapgiuaky.controller;

import com.hutech.baitapgiuaky.entities.Book;
import com.hutech.baitapgiuaky.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "listBooks";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable UUID id, Model model) {
        Optional<Book> book = bookService.findById(id);
        book.ifPresent(value -> model.addAttribute("book", value));
        return "editBook";
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable UUID id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String viewBook(@PathVariable UUID id, Model model) {
        Optional<Book> book = bookService.findById(id);
        book.ifPresent(value -> model.addAttribute("book", value));
        return "viewBook";
    }
}