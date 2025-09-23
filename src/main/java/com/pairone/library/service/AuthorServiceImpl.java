package com.pairone.library.service;

import com.pairone.library.dto.author.request.AuthorCreateRequest;
import com.pairone.library.dto.author.request.AuthorUpdateRequest;
import com.pairone.library.dto.author.response.AuthorCreateResponse;
import com.pairone.library.dto.author.response.AuthorDeleteResponse;
import com.pairone.library.dto.author.response.AuthorGetResponse;
import com.pairone.library.dto.author.response.AuthorUpdateResponse;
import com.pairone.library.entity.Author;
import com.pairone.library.mapper.AuthorMapper;
import com.pairone.library.repository.AuthorRepository;
import com.pairone.library.rules.AuthorBusinessRule;
import com.pairone.library.service.abstractservice.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMappers;
    private final AuthorBusinessRule authorBusinessRule;
    Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorBusinessRule authorBusinessRule) {
        this.authorRepository = authorRepository;
        this.authorBusinessRule = authorBusinessRule;
        this.authorMappers = AuthorMapper.INSTANCE;

    }

    @Override
    public AuthorCreateResponse createAuthor(AuthorCreateRequest dto) {
        Author save = authorMappers.mapToEntity(dto);
        authorBusinessRule.authorFirstNameAndLastNameIsEmpty(save);
        save = authorRepository.save(save);
        logger.info(save + " Object added.");
        return authorMappers.mapCreateToDto(save);
    }

    @Override
    public AuthorUpdateResponse updateAuthor(AuthorUpdateRequest dto) {
        authorBusinessRule.findByIdIsEmpty(dto.getAuthorId());
        Author save = authorMappers.mapToEntity(dto);
        save.setId(dto.getAuthorId());
         authorRepository.save(save);
        return authorMappers.mapUpdateToDto(save);
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
        Pageable pageable = PageRequest.of(page, size);
        Page<Author> authorPage = authorBusinessRule.findAll(pageable);
        return authorPage.map(authorMappers::mapToAuthorGet);
    }
}
