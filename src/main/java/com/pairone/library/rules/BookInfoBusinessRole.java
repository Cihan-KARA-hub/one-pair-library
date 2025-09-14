package com.pairone.library.rules;

import com.pairone.library.entity.Author;
import com.pairone.library.entity.BookInfo;
import com.pairone.library.repository.BookInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookInfoBusinessRole {
    private final BookInfoRepository bookInfoRepository;

    public BookInfoBusinessRole(BookInfoRepository bookInfoRepository) {
        this.bookInfoRepository = bookInfoRepository;
    }

    public void bookInfoMustNotExistWithGivenId(String isbn) {
        Optional<BookInfo> info = bookInfoRepository.findByIsbn(isbn);
        if (info.isPresent()) {
            throw new RuntimeException("data is empty");
        }
    }
    public BookInfo bookInfoMustExistWithGivenId(Integer id) {
       return bookInfoRepository.findById(id).orElseThrow(() -> new RuntimeException("data is empty"));
    }

    public Page<BookInfo> findAll(Pageable pageable) {
        return bookInfoRepository.findAll(pageable);
    }
}
