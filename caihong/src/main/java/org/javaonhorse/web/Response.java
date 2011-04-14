package org.javaonhorse.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response {

    private final HttpServletResponse httpServletResponse;
    private boolean rendered = false;

    public Response(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public void write(String text) {
        try {
            httpServletResponse.getWriter().print(text);
            rendered = true;
        } catch (IOException e) {
            throw new UnexpectedException(e);
        }
    }

    public boolean isRendered() {
        return rendered;
    }
}
