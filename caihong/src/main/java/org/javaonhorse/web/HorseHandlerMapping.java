package org.javaonhorse.web;

import org.springframework.web.servlet.handler.AbstractUrlHandlerMapping;

import javax.servlet.http.HttpServletRequest;

public class HorseHandlerMapping extends AbstractUrlHandlerMapping {

    @Override
    protected Object lookupHandler(String urlPath, HttpServletRequest request) throws Exception {
        System.out.println("Looking for :" + urlPath);
        String[] parts = urlPath.split("/");
        String controller = parts[1];
        String action = parts[2];
        String controllerClassName = controller.substring(0, 1).toUpperCase().concat(controller.substring(1)).concat("Controller");
        controllerClassName = "com.tankcraft.core.web.f." + controllerClassName;
        return Class.forName(controllerClassName).newInstance();
    }

}
