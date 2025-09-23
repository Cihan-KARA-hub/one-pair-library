package com.pairone.library.controller;

import com.pairone.library.dto.bookinfo.reponse.BookInfoCreateResponseDto;
import com.pairone.library.dto.bookinfo.reponse.BookInfoGetResponseDto;
import com.pairone.library.dto.bookinfo.reponse.BookInfoUpdateResponseDto;
import com.pairone.library.dto.bookinfo.request.BookInfoCreateRequestDto;
import com.pairone.library.dto.bookinfo.request.BookInfoUpdateRequestDto;
import com.pairone.library.service.abstractservice.BookInfoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookInfo/")
public class BookInfoController {

    private final BookInfoService bookInfoService;

    public BookInfoController(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookInfoCreateResponseDto create(@Valid @RequestBody BookInfoCreateRequestDto dto) {
        return bookInfoService.save(dto);
    }

    @PutMapping()
    public BookInfoUpdateResponseDto update(@Valid @RequestBody BookInfoUpdateRequestDto dto
    ) {
        return bookInfoService.update(dto);
    }

    @GetMapping("{id}")
    public BookInfoGetResponseDto getById(@PathVariable Integer id) {
        return bookInfoService.getBookInfo(id);
    }

    @GetMapping
    public Page<BookInfoGetResponseDto> getAll(@RequestParam(defaultValue = "5") int size,
                                               @RequestParam(defaultValue = "0") int page) {
        return bookInfoService.getAll(size, page);
    }



}
