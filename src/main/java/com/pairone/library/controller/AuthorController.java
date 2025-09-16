package com.pairone.library.controller;

import com.pairone.library.dto.author.request.AuthorCreateRequest;
import com.pairone.library.dto.author.request.AuthorUpdateRequest;
import com.pairone.library.dto.author.response.AuthorCreateResponse;
import com.pairone.library.dto.author.response.AuthorGetResponse;
import com.pairone.library.dto.author.response.AuthorUpdateResponse;
import com.pairone.library.service.abstractservice.AuthorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public AuthorCreateResponse createAuthor(@Valid @RequestBody AuthorCreateRequest dto) {
        return authorService.createAuthor(dto);
    }

    @PutMapping("/{id}")
    public AuthorUpdateResponse updateAuthor(@Valid @RequestBody AuthorUpdateRequest dto) {
        return authorService.updateAuthor(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
    }

    @GetMapping("/{id}")
    public AuthorGetResponse getAuthorById(@PathVariable Integer id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping
    public Page<AuthorGetResponse> getAllAuthors(@RequestParam(defaultValue = "5") int size,
                                                 @RequestParam(defaultValue = "0") int page) {
        return authorService.getAllAuthors(size, page);
    }
}
