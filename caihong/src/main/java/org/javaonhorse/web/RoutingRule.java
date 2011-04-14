package org.javaonhorse.web;

public final class RoutingRule {
    private final String url;
    private final Class<? extends Controller> controllerClass;

    public RoutingRule(String url, Class<? extends Controller> controllerClass) {
        this.url = url;
        this.controllerClass = controllerClass;
    }

    public String getUrl() {
        return url;
    }

    public Class<? extends Controller> getControllerClass() {
        return controllerClass;
    }
}
