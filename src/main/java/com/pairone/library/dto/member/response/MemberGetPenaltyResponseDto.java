package com.pairone.library.dto.member.response;

import com.pairone.library.dto.penalty.PagePenaltyRes;

import java.util.List;

public class MemberGetPenaltyResponseDto {
    private MemberListDto listMember;
    private PagePenaltyRes pagePenalty;

    public MemberGetPenaltyResponseDto(MemberGetResponseDto memDto, List<PagePenaltyRes> penaltiesRes) {

    }

    public MemberListDto getListMember() {
        return listMember;
    }

    public MemberGetPenaltyResponseDto(MemberListDto listMember, PagePenaltyRes pagePenalty) {
        this.listMember = listMember;
        this.pagePenalty = pagePenalty;
    }

    public void setListMember(MemberListDto listMember) {
        this.listMember = listMember;
    }

    public PagePenaltyRes getPagePenalty() {
        return pagePenalty;
    }

    public void setPagePenalty(PagePenaltyRes pagePenalty) {
        this.pagePenalty = pagePenalty;
    }
}
