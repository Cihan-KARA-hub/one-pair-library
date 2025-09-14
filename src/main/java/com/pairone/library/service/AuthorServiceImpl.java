package com.pairone.library.service;
import com.pairone.library.mapper.AuthorMapper;
import com.pairone.library.repository.AuthorRepository;
import com.pairone.library.service.abstractservice.AuthorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.pairone.library.dto.author.AuthorDto;
import com.pairone.library.entity.Author;
//import com.pairone.library.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto dto) {
        Author author = new Author();
        author.setFirstname(dto.getFirstname());
        author.setLastname(dto.getLastname());
        Author saved = authorRepository.save(author);
        return authorMapper.mapToDto(saved);
    }

    @Override
    public AuthorDto updateAuthor(Integer id, AuthorDto dto) {
        Author author = authorRepository.findById(id).orElseThrow();
        author.setFirstname(dto.getFirstname());
        author.setLastname(dto.getLastname());
        Author updated = authorRepository.save(author);
        return authorMapper.mapToDto(updated);
    }

    @Override
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto getAuthorById(Integer id) {
        return authorRepository.findById(id).map(authorMapper::mapToDto).orElse(null);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream().map(authorMapper::mapToDto).collect(Collectors.toList());
    }


}
