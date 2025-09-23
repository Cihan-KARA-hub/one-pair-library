package com.pairone.library.dto.member.response;

public class MemberActiveResponseDto {
    private String id;

    public MemberActiveResponseDto(String id, boolean active) {
        this.id = id;
        this.active = active;
    }

    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
