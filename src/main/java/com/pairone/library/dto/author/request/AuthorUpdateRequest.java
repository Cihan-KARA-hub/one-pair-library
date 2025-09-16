package com.pairone.library.dto.author.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AuthorUpdateRequest {
    @NotNull
    private Integer id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;

    public AuthorUpdateRequest() {
    }

    public Integer getAuthorId() {
        return id;
    }

    public void setAuthorId(Integer id) {
        this.id = id;
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
                "authorId=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
