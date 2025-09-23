package com.pairone.library.controller;

import com.pairone.library.dto.member.request.MemberCreateRequestDto;
import com.pairone.library.dto.member.response.MemberActiveResponseDto;
import com.pairone.library.dto.member.response.MemberGetPenaltyResponseDto;
import com.pairone.library.dto.member.response.MemberGetResponseDto;
import com.pairone.library.dto.member.response.MemberListDto;
import com.pairone.library.entity.enums.MembershipLevel;
import com.pairone.library.service.MemberServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members/")
public class MemberController {
    private final MemberServiceImpl memberServiceImpl;

    public MemberController(MemberServiceImpl memberServiceImpl) {
        this.memberServiceImpl = memberServiceImpl;
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<MemberListDto> allMember() {
        return memberServiceImpl.getMembers();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addMember(@RequestBody MemberCreateRequestDto member) {
        memberServiceImpl.addMember(member);
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MemberGetResponseDto get(@Valid @PathVariable Integer id) {
        return memberServiceImpl.getMemberId(id);
    }
    @PatchMapping("{id}/activation")
    public MemberActiveResponseDto activateMember(@PathVariable Integer id,@RequestParam boolean activated) {
        return memberServiceImpl.setActive(id,activated);
    }

    // • GET /api/members?status=ACTIVE&email=...
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<MemberGetResponseDto> getQuery(
            @Valid @RequestParam(required = false) String email,
            @Valid @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "0") int page) {
        return memberServiceImpl.filterQuery(email, status, size, page);

    }

    // • PATCH /api/members/{id}/status?value=BANNED
    @PatchMapping("{id}")
    public void updateStatus(@PathVariable Integer id, @RequestParam MembershipLevel status) {
        memberServiceImpl.updateStatus(id, status);
    }
    // • GET /api/members/{id}/fines?isPaid=false

    @GetMapping("{id}/fines")
    public MemberGetPenaltyResponseDto getFinesIsPaid(@PathVariable Integer id,@RequestParam boolean isPaid) {
       return memberServiceImpl.getFinesIsPaid(id,isPaid);
    }


}
