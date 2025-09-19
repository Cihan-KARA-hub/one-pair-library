package com.pairone.library.dto.member.request;

import com.pairone.library.entity.Address;
import com.pairone.library.entity.Role;
import com.pairone.library.entity.enums.MembershipLevel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class MemberCreateRequestDto {
    @NotNull
    private Address address;
    @NotNull
    private Role role;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String eMail;
    @Size(min = 11, max = 11)
    private String phone;
    private String firstname;
    private String lastname;
    @NotNull
    private MembershipLevel members;

    public @NotNull Address getAddress() {
        return address;
    }

    public void setAddress(@NotNull Address address) {
        this.address = address;
    }

    public @NotNull Role getRole() {
        return role;
    }

    public void setRole(@NotNull Role role) {
        this.role = role;
    }

    public @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}") String geteMail() {
        return eMail;
    }

    public void seteMail(@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}") String eMail) {
        this.eMail = eMail;
    }

    public @Size(min = 11, max = 11) String getPhone() {
        return phone;
    }

    public void setPhone(@Size(min = 11, max = 11) String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public @NotNull MembershipLevel getMembers() {
        return members;
    }

    public void setMembers(@NotNull MembershipLevel members) {
        this.members = members;
    }
}
