package com.pairone.library.rules;

import com.pairone.library.entity.Book;
import com.pairone.library.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookBusinessRule {
    private final BookRepository bookRepository;

    public BookBusinessRule(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void findBookIsNotExists(Book book) {
        Optional<Book> bookEntity = bookRepository.findbyBook(book);
        if (bookEntity.isPresent()) {
            throw new RuntimeException("Book already exists");
        }
    }

    public Book findBookIsExists(Integer bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

    }

}
