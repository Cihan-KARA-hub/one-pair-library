package com.pairone.library.dto.member.response;


public class MemberListDto {
    private Integer address;
    private int role;
    private String eMail;
    private String phone;
    private String firstname;
    private String lastname;

    public MemberListDto() {
    }

    public MemberListDto(Integer address, int roleId, String eMail, String phone, String firstname, String lastname) {
        this.address = address;
        this.role = roleId;
        this.eMail = eMail;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int roleId) {
        this.role = roleId;
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
