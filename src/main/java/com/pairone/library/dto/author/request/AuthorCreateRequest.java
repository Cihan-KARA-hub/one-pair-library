package com.pairone.library.dto.author.request;

import jakarta.validation.constraints.NotBlank;

public class AuthorCreateRequest {
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;

    public AuthorCreateRequest() {
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

    @Override
    public String toString() {
        return "AuthorDto{" +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
