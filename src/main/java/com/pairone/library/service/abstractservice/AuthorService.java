package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.author.request.AuthorCreateRequest;
import com.pairone.library.dto.author.request.AuthorUpdateRequest;
import com.pairone.library.dto.author.response.AuthorCreateResponse;
import com.pairone.library.dto.author.response.AuthorDeleteResponse;
import com.pairone.library.dto.author.response.AuthorGetResponse;
import com.pairone.library.dto.author.response.AuthorUpdateResponse;
import org.springframework.data.domain.Page;

public interface AuthorService {
    AuthorCreateResponse createAuthor(AuthorCreateRequest dto);
    AuthorUpdateResponse updateAuthor(AuthorUpdateRequest dto);
    AuthorDeleteResponse deleteAuthor(Integer id);
    AuthorGetResponse getAuthorById(Integer id);
    Page<AuthorGetResponse> getAllAuthors(int size, int page);

}
