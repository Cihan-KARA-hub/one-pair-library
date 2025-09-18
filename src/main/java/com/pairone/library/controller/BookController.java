package com.pairone.library.controller;

import com.pairone.library.dto.book.request.BookCreateRequest;
import com.pairone.library.dto.book.request.BookUpdateRequest;
import com.pairone.library.dto.book.response.BookCreateResponse;
import com.pairone.library.dto.book.response.BookDeleteResponse;
import com.pairone.library.dto.book.response.BookListResponse;
import com.pairone.library.dto.bookinfo.reponse.BookInfoGetResponseDto;
import com.pairone.library.service.abstractservice.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookCreateResponse createBook(@Valid @RequestBody BookCreateRequest book) {
        return bookService.create(book);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@Valid @RequestBody BookUpdateRequest book) {
        bookService.update(book);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookDeleteResponse deleteBook(@PathVariable Integer bookId) {
        return bookService.delete(bookId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Page<BookListResponse> getAllBooks(@RequestParam(defaultValue = "5") int size,
                                              @RequestParam(defaultValue = "0") int page) {
        return bookService.getAll(size, page);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<BookListResponse> getIsbnAndTitleAndAuthorAndAvailable(
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false ,defaultValue = "true") Boolean available,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "0") int page
            ){
        return bookService.getIsbnAndTitleAndAuthorAndAvailable(isbn,title,author,available,size,page);
    }
    // PATCH /api/books/{id}/copies?delta=+3 (stok artır/azalt)
    @PatchMapping("/{id}/copies")
    @ResponseStatus(HttpStatus.OK)
    public void copiesUpdate(@PathVariable Integer id, @RequestParam int copies) {
        bookService.totalCopiesUpdate(id,copies);
    }

}
