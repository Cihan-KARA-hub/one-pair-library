package com.pairone.library.service;

import com.pairone.library.dto.author.request.AuthorCreateRequestDto;
import com.pairone.library.dto.author.request.AuthorUpdateRequestDto;
import com.pairone.library.dto.author.response.AuthorCreateResponse;
import com.pairone.library.dto.author.response.AuthorDeleteResponse;
import com.pairone.library.dto.author.response.AuthorGetResponse;
import com.pairone.library.dto.author.response.AuthorUpdateResponse;
import com.pairone.library.entity.Author;
import com.pairone.library.mapper.AuthorMapper;
import com.pairone.library.repository.AuthorRepository;
import com.pairone.library.rules.AuthorBusinessRule;
import com.pairone.library.service.abstractservice.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMappers;
    private final AuthorBusinessRule authorBusinessRule;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorBusinessRule authorBusinessRule) {
        this.authorRepository = authorRepository;
        this.authorBusinessRule = authorBusinessRule;
        this.authorMappers = AuthorMapper.INSTANCE;

    }

    @Override
    public AuthorCreateResponse createAuthor(AuthorCreateRequestDto dto) {
        Author save = authorMappers.mapToEntity(dto);
        authorBusinessRule.authorFirstNameAndLastNameIsEmpty(save);
        authorRepository.save(save);
        return authorMappers.mapCreateToDto(save);
    }
    @Override
    public AuthorUpdateResponse updateAuthor(AuthorUpdateRequestDto dto) {
        authorBusinessRule.findByIdIsEmpty(dto.getAuthorId());
        Author save = authorMappers.mapToEntity(dto);
        Author updated = authorRepository.save(save);
        return authorMappers.mapUpdateToDto(updated);
    }
    @Override
    public AuthorDeleteResponse deleteAuthor(Integer id) {
        Author author = authorBusinessRule.findByIdIsEmpty(id);
        authorRepository.delete(author);
        return authorMappers.mapToAuthorDelete(author);
    }
    @Override
    public AuthorGetResponse getAuthorById(Integer id) {
        Author author = authorBusinessRule.findByIdIsEmpty(id);
        return authorMappers.mapToAuthorGet(author);
    }
    @Override
    public Page<AuthorGetResponse> getAllAuthors(int size, int page) {
        Pageable pageable = PageRequest.of(size, page);
        Page<Author> authorPage = authorBusinessRule.findAll(pageable);
        return authorPage.map(authorMappers::mapToAuthorGet);
    }


}
