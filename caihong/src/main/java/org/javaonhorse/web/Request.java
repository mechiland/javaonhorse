package org.javaonhorse.web;

import javax.servlet.http.HttpServletRequest;

public class Request {

    private final HttpServletRequest httpServletRequest;

    public Request(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public Params getParams() {
        return new Params(httpServletRequest);
    }
}
