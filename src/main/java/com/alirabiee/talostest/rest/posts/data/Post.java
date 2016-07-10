package com.alirabiee.talostest.rest.posts.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Ali Rabiee on 2016-07-10.
 */
@JsonIgnoreProperties( ignoreUnknown = true )
public class Post {
    private Long id;
    private Long userId;
    private String title;
    private String body;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }
}
