package com.pairone.library.dto.member.request;

import com.pairone.library.dto.address.request.AddressCreateRequest;
import com.pairone.library.dto.role.RoleCreateRequest;
import com.pairone.library.entity.enums.MembershipLevel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class MemberCreateRequestDto {
    @NotNull
    private AddressCreateRequest address;
    @NotNull
    private RoleCreateRequest role;

    public @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}") String geteMail() {
        return eMail;
    }

    public void seteMail(@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}") String eMail) {
        this.eMail = eMail;
    }

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String eMail;
    @Size(min = 11, max = 11)
    private String phone;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotNull
    private MembershipLevel membersShipLevel;
    public MemberCreateRequestDto() {
    }



    public @NotNull RoleCreateRequest getRole() {
        return role;
    }

    public void setRole(@NotNull RoleCreateRequest role) {
        this.role = role;
    }

    public @NotNull AddressCreateRequest getAddress() {
        return address;
    }

    public void setAddress(@NotNull AddressCreateRequest address) {
        this.address = address;
    }


    public @Size(min = 11, max = 11) String getPhone() {
        return phone;
    }

    public void setPhone(@Size(min = 11, max = 11) String phone) {
        this.phone = phone;
    }

    public @NotBlank String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NotBlank String firstname) {
        this.firstname = firstname;
    }

    public @NotBlank String getLastname() {
        return lastname;
    }

    public void setLastname(@NotBlank String lastname) {
        this.lastname = lastname;
    }

    public @NotNull MembershipLevel getMembersShipLevel() {
        return membersShipLevel;
    }

    public void setMembersShipLevel(@NotNull MembershipLevel membersShipLevel) {
        this.membersShipLevel = membersShipLevel;
    }

}
