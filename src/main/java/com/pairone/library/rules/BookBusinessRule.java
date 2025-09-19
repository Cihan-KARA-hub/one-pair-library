package com.pairone.library.rules;

import com.pairone.library.entity.Book;
import com.pairone.library.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class BookBusinessRule {

    private final BookRepository bookRepository;

    public BookBusinessRule(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void incrementBook(Integer bookId) {
        Book book = findBookIsExists(bookId);
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
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

    public Page<Book> getAll(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        if (books.isEmpty()) throw new RuntimeException("not found data");
        return books;
    }

    public Book validateBookAvailability(Integer bookId) {
        Book book = findBookIsExists(bookId);

        if (book.getAvailableCopies() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Kitap ödünç verilemez. Mevcut kopya sayısı: " + book.getAvailableCopies());
        }

        return book;
    }

    public void decreaseAvailableCopies(Integer bookId) {
        Book book = findBookIsExists(bookId);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Page<Book> getIsbnAndTitleAndAuthorAndAvailable(String isbn, String title, String author, Boolean available, Pageable pageable) {
        Page<Book> book = bookRepository.searchBooks(isbn, title, author, available, pageable);
        if (book.isEmpty()) throw new RuntimeException("not found data");
        return book;
    }
}