package com.alirabiee.talostest.rest.common.client;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ali Rabiee on 2016-07-10.
 */
public interface RestClient {
    < T > T get(String url, Class< T > resultClass) throws IOException;

    < T > List< T > getList(String url, Class< T > resultClass) throws IOException;
}
