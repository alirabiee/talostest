package com.alirabiee.talostest.rest.common.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ali Rabiee on 2016-07-10.
 * There is much room for review and optimization here.
 */
@Component
public class TalosClient implements RestClient {
    private final static Logger logger = LogManager.getLogger( TalosClient.class );

    @Value( "${rest.server.baseUrl}" )
    private String baseUrl;

    private final Client client = Client.create();

    @Override
    public < T > T get(final String url, final Class< T > resultClass) throws IOException {
        final String restURL = baseUrl + url;

        if ( logger.isDebugEnabled() ) logger.debug( "restURL = " + restURL );

        final WebResource webResource = client.resource( restURL );

        final ClientResponse response =
            webResource
                .header( "User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:47.0) Gecko/20100101 Firefox/47.0" )
                .header( "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" )
                .get( ClientResponse.class );

        if ( response.getStatus() != 200 ) {
            throw new RuntimeException( "Failed : HTTP error code : " + response.getStatus() );
        }

        final ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue( response.getEntity( String.class ), resultClass );
    }

    @Override
    public < T > List< T > getList(final String url, final Class< T > resultClass) throws IOException {
        final String restURL = baseUrl + url;

        if ( logger.isDebugEnabled() ) logger.debug( "restURL = " + restURL );

        final WebResource webResource = client.resource( restURL );

        final ClientResponse response =
            webResource
                .header( "User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:47.0) Gecko/20100101 Firefox/47.0" )
                .header( "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" )
                .get( ClientResponse.class );

        if ( response.getStatus() != 200 ) {
            throw new RuntimeException( "Failed : HTTP error code : " + response.getStatus() );
        }

        final ObjectMapper objectMapper = new ObjectMapper();

        final List list = objectMapper.readValue( response.getEntity( String.class ), List.class );

        final ArrayList< T > result = new ArrayList<>();

        for ( Object o : list ) {
            try {
                final T bean = resultClass.newInstance();

                BeanUtils.populate( bean, ( Map< String, ? extends Object > ) o );
                result.add( bean );
            }
            catch ( IllegalAccessException | InvocationTargetException | InstantiationException e ) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
