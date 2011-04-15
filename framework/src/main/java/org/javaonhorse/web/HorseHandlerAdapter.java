package org.javaonhorse.web;

import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class HorseHandlerAdapter implements HandlerAdapter {

    public HorseHandlerAdapter() {

    }

    public boolean supports(Object handler) {
        return handler instanceof Controller;
    }

    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String servletPath = request.getServletPath();
        String urlPath = requestURI.replace(servletPath, "");
        String controller = urlPath.split("/")[1];
        String action = urlPath.split("/")[2];
        String method = action;
        if (isKeyWord(action)) {
            method = "_" + action;
        }
        Method m = handler.getClass().getMethod(method);
        m.setAccessible(true);
        Controller controller1 = (Controller) handler;
        controller1.init(new Request(request), new Response(response));
        m.invoke(handler);
        if (controller1.isRendered()) {
            return null;
        }
        return new ModelAndView(controller + "/" + action, controller1.getLocals()).addObject("this", controller1);
    }

    private boolean isKeyWord(String method) {
        List<String> keyword = Arrays.asList("new");
        return CollectionUtils.contains(keyword.iterator(), method);
    }

    public long getLastModified(HttpServletRequest request, Object handler) {
        return -1L;
    }
}
