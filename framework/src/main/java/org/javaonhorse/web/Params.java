package org.javaonhorse.web;

import javax.servlet.http.HttpServletRequest;

public class Params {

    private HttpServletRequest httpServletRequest;

    public Params(HttpServletRequest httpServletRequest) {

        this.httpServletRequest = httpServletRequest;
    }

    public String get(String parameterName) {
        return httpServletRequest.getParameter(parameterName);
    }

}
