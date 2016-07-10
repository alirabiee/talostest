package com.alirabiee.talostest.rest.common.exception;

/**
 * Created by Ali Rabiee on 2016-07-10.
 */
public class ApplicationException extends Exception {
    public ApplicationException() {
        super();
    }

    public ApplicationException(final String message) {
        super( message );
    }

    public ApplicationException(final String message, final Throwable cause) {
        super( message, cause );
    }

    public ApplicationException(final Throwable cause) {
        super( cause );
    }

    protected ApplicationException(final String message, final Throwable cause, final boolean enableSuppression,
                                   final boolean writableStackTrace) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
