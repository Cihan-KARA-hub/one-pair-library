package com.pairone.library.rules;

import com.pairone.library.entity.Author;
import com.pairone.library.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AuthorBusinessRule {
    private final AuthorRepository authorRepository;

    public AuthorBusinessRule(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void authorFirstNameAndLastNameIsEmpty(Author author) {
        Author author1 = authorRepository.findByIgnoreCaseFirstnameAndLastname(author.getFirstname(), author.getLastname());
        if (author1 != null) {
            throw new RuntimeException("Data not found");
        }

    }

    public Author findByIdIsEmpty(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
    }

    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    public Set<Author> findByIds(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new RuntimeException("Author listesi boş olamaz");
        }
        return ids.stream()
                .map(this::findByIdIsEmpty)
                .collect(Collectors.toSet());
    }
}
