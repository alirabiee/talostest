package com.alirabiee.talostest.rest.posts.web;

import com.alirabiee.talostest.rest.common.exception.ResourceUnavailableException;
import com.alirabiee.talostest.rest.posts.data.Post;
import com.alirabiee.talostest.rest.posts.data.PostDAO;
import com.alirabiee.talostest.rest.users.data.User;
import com.alirabiee.talostest.rest.users.data.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali Rabiee on 2016-07-10.
 */
@Controller
@RequestMapping( "/api/posts" )
public class PostsController {

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping
    @ResponseBody
    public List< PostDTO > getPosts() throws ResourceUnavailableException {
        final List< Post > posts = postDAO.getPosts();

        final ArrayList< PostDTO > result = new ArrayList<>( posts.size() );

        posts.stream().forEach(
            p -> result.add( new PostDTO( p.getId(), p.getTitle() ) )
        );

        return result;
    }

    @RequestMapping("/{postId}")
    @ResponseBody
    public PostDTO getPost(@PathVariable Long postId) throws ResourceUnavailableException {
        final PostDTO dto = new PostDTO();

        final Post post = postDAO.getPost( postId );

        dto.setId( post.getId() );
        dto.setTitle( post.getTitle() );
        dto.setBody( post.getBody() );

        if ( post.getUserId() != null ) {
            final User user = userDAO.getUser( post.getUserId() );

            dto.setUser( user.getName() );
        }

        return dto;
    }

}
