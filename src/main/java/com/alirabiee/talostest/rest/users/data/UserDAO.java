package com.alirabiee.talostest.rest.users.data;

import com.alirabiee.talostest.rest.common.client.RestClient;
import com.alirabiee.talostest.rest.common.data.BaseDAO;
import com.alirabiee.talostest.rest.common.exception.ResourceUnavailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by Ali Rabiee on 2016-07-10.
 */
@Repository
public class UserDAO extends BaseDAO {
    @Autowired
    private RestClient restClient;

    public User getUser(final Long userId) throws ResourceUnavailableException {
        try {
            return restClient.get( "/users/" + userId, User.class );
        }
        catch ( IOException e ) {
            throw new ResourceUnavailableException( e );
        }
    }
}
