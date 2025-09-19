package com.pairone.library.dto.member.response;


public class MemberListDto {
    private int addressId;
    private int roleId;
    private String eMail;
    private String phone;
    private String firstname;
    private String lastname;

    public MemberListDto() {
    }

    public MemberListDto(int addressId, int roleId, String eMail, String phone, String firstname, String lastname) {
        this.addressId = addressId;
        this.roleId = roleId;
        this.eMail = eMail;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
