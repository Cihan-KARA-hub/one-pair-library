package com.pairone.library.entity;

import jakarta.persistence.*;
//yapıldı
@Entity
@Table(name = "member")
public class Member {
    /* member_id int
address_id int
role_id int
email varchar
phone varchar
firstname varchar
lastname varchar
is_active boolean
   */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address addressId;
    @OneToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role roleId;
    @Column(unique = true, nullable = false, name = "email")
    private String eMail;
    @Column(unique = true, nullable = false, name = "phone")
    private String phone;
    @Column(nullable = false, name = "firstname")
    private String firstname;
    @Column(nullable = false, name = "lastname")
    private String lastname;
    @Column(nullable = false, name = "is_active")
    private boolean isActive = false;
    public Member() {
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
