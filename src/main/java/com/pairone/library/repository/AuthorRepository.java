package com.pairone.library.repository;
import com.pairone.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "Select a from Author a WHERE a.firstname like :name",nativeQuery = false)
    List<Author> findByFirstname(String name);
    //findByNameLike ->select * from anathors where name %lİKE%
    Author findByIgnoreCaseFirstnameAndLastname(String firstname, String lastname);
}
