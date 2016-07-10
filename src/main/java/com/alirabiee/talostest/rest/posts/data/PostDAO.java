package com.alirabiee.talostest.rest.posts.data;

import com.alirabiee.talostest.rest.common.client.RestClient;
import com.alirabiee.talostest.rest.common.data.BaseDAO;
import com.alirabiee.talostest.rest.common.exception.ResourceUnavailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ali Rabiee on 2016-07-10.
 */
@Repository
public class PostDAO extends BaseDAO {
    @Autowired
    private RestClient restClient;

    public List< Post > getPosts() throws ResourceUnavailableException {
        try {
            return restClient.getList( "/posts", Post.class );
        }
        catch ( IOException e ) {
            throw new ResourceUnavailableException( e );
        }
    }

    public Post getPost(final Long postId) throws ResourceUnavailableException {
        try {
            return restClient.get( "/posts/" + postId, Post.class );
        }
        catch ( IOException e ) {
            throw new ResourceUnavailableException( e );
        }
    }
}
