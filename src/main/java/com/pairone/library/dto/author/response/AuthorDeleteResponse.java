package com.pairone.library.dto.author.response;

import jakarta.validation.constraints.NotBlank;

public class AuthorDeleteResponse {
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;

    public AuthorDeleteResponse() {
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
