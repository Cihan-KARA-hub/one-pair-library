package com.pairone.library.repository;

import com.pairone.library.entity.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo, Integer> {
    Optional<BookInfo> findByBookId(int bookId);
}
