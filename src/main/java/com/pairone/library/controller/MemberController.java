package com.pairone.library.controller;

import com.pairone.library.dto.member.request.MemberCreateRequestDto;
import com.pairone.library.dto.member.response.MemberListDto;
import com.pairone.library.service.MemberServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/member")
public class MemberController {
    private final MemberServiceImpl memberServiceImpl;

    public MemberController(MemberServiceImpl memberServiceImpl) {
        this.memberServiceImpl = memberServiceImpl;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MemberListDto> allMember() {
        return memberServiceImpl.getMembers();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addMember(@RequestBody MemberCreateRequestDto member) {
        memberServiceImpl.addMember(member);
    }
    //TODO  • GET /api/members/{id} → MemberResponse
    // • GET /api/members?status=ACTIVE&email=...
    // • PATCH /api/members/{id}/status?value=BANNED
    // • GET /api/members/{id}/fines?isPaid=false
}
