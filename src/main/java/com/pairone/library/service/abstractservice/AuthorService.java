package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.author.request.AuthorCreateRequestDto;
import com.pairone.library.dto.author.request.AuthorUpdateRequestDto;
import com.pairone.library.dto.author.response.AuthorCreateResponse;
import com.pairone.library.dto.author.response.AuthorDeleteResponse;
import com.pairone.library.dto.author.response.AuthorGetResponse;
import com.pairone.library.dto.author.response.AuthorUpdateResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthorService {
    AuthorCreateResponse createAuthor(AuthorCreateRequestDto dto);
    AuthorUpdateResponse updateAuthor(AuthorUpdateRequestDto dto);
    AuthorDeleteResponse deleteAuthor(Integer id);
    AuthorGetResponse getAuthorById(Integer id);
    Page<AuthorGetResponse> getAllAuthors(int size, int page);

}
