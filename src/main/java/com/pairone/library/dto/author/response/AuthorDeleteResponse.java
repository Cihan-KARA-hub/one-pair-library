package com.pairone.library.dto.author.response;

public class AuthorDeleteResponse {
    private String firstname;
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
