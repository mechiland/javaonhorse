package org.javaonhorse.web;

import java.util.Map;
import java.util.TreeMap;

public class Controller {
    protected Request request;
    private Response response;
    protected Params params;
    protected final Map<String, Object> locals = new TreeMap<String, Object>();

    public final void init(Request request, Response response) {
        this.request = request;
        this.response = response;
        params = request.getParams();
    }

    public void renderText(String text) {
        response.write(text);
    }

    public boolean isRendered() {
        return response.isRendered();
    }

    public Map<String, Object> getLocals() {
        return locals;
    }

}
