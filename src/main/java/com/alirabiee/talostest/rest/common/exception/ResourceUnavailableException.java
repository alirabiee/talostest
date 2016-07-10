package com.alirabiee.talostest.rest.common.exception;

/**
 * Created by Ali Rabiee on 2016-07-10.
 */
public class ResourceUnavailableException extends ApplicationException {
    public ResourceUnavailableException() {
        super();
    }

    public ResourceUnavailableException(final String message) {
        super( message );
    }

    public ResourceUnavailableException(final String message, final Throwable cause) {
        super( message, cause );
    }

    public ResourceUnavailableException(final Throwable cause) {
        super( cause );
    }

    protected ResourceUnavailableException(final String message, final Throwable cause,
                                           final boolean enableSuppression,
                                           final boolean writableStackTrace) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
