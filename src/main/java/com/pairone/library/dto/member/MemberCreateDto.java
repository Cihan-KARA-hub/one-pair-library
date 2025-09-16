package com.pairone.library.dto.member;

import com.pairone.library.entity.Address;
import com.pairone.library.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;


public class MemberCreateDto {

    private Address address;
    private Role role;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String eMail;
    @Size(min =11, max = 11)
    private String phone;
    private String firstname;
    private String lastname;
    public MemberCreateDto() {
    }
    public MemberCreateDto(Address address, Role role, String eMail, String phone, String firstname, String lastname) {
        this.address = address;
        this.role = role;
        this.eMail = eMail;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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
}
