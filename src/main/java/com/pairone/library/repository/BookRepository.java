package com.pairone.library.repository;

import com.pairone.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("""
        SELECT DISTINCT b
        FROM Book b
        JOIN b.bookinfoId bi
        LEFT JOIN b.authors a
        WHERE (:isbn IS NULL OR bi.isbn = :isbn)
          AND (:title IS NULL OR LOWER(b.name) LIKE LOWER(CONCAT('%', :title, '%')))
          AND (:author IS NULL OR LOWER(a.firstname) LIKE LOWER(CONCAT('%', :author, '%')))
          AND (:available IS NULL OR\s
               (:available = true AND b.availableCopies > 0) OR
               (:available = false AND  bi.totalCopy-bi.availableCopies > 0))
       \s""")
    Page<Book> searchBooks(
            @Param("isbn") String isbn,
            @Param("title") String title,
            @Param("author") String author,
            @Param("available") Boolean available,
            Pageable pageable);;
}
