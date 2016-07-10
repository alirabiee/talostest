package com.alirabiee.talostest.rest.posts.web;

import com.alirabiee.talostest.rest.common.response.RestResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Ali Rabiee on 2016-07-10.
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
public class PostDTO extends RestResponse {
    private Long id;
    private String title;
    private String user;
    private String body;

    public PostDTO() {
    }

    public PostDTO(final Long id, final String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }
}
