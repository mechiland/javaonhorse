package org.javaonhorse.web;

public interface RouteMap {

    void root(Class<? extends Controller> controllerClass);

    void resources(String resourcesName, Class<? extends Controller> controllerClass);

    void connect(String url, String controllerAction);

    Controller findController(Request request);
}
