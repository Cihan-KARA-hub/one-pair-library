package com.pairone.library.rules;

import com.pairone.library.entity.BookInfo;
import com.pairone.library.repository.BookInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookInfoBusinessRule {
    private final BookInfoRepository bookInfoRepository;

    public BookInfoBusinessRule(BookInfoRepository bookInfoRepository) {
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

    public boolean totalCurrentIsGreaterThan(int totalCopy, int availableCopies) {
        return totalCopy > availableCopies;

    }

    public BookInfo updateStockCheck(Integer bookId, int copies) {
        BookInfo bookInfo = bookInfoRepository.findByBookId(bookId).orElseThrow(() -> new RuntimeException("data is empty"));
        bookInfo.setTotalCopy(bookInfo.getTotalCopy() + copies);
        bookInfo.setAvailableCopies(bookInfo.getAvailableCopies() + copies);
        checkCopiesNotNegative(bookInfo.getTotalCopy(), bookInfo.getAvailableCopies());
        return bookInfo;

    }
    public void bookInfoSave(BookInfo bookInfo) {
        bookInfoRepository.save(bookInfo);
    }

    private void checkCopiesNotNegative(int total, int available) {
        if (total < 0 || available < 0) {
            throw new RuntimeException("total/available copies can't be less than 0");
        }
    }

}
