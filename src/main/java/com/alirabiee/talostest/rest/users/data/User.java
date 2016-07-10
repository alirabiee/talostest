package com.alirabiee.talostest.rest.users.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Ali Rabiee on 2016-07-10.
 */
@JsonIgnoreProperties( ignoreUnknown = true )
public class User {
    private Long id;
    private String name;
    private String username;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
