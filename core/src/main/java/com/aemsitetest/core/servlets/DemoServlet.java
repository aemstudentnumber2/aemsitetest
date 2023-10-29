package com.aemsitetest.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.Objects;

@Component(service = { Servlet.class })
@SlingServletResourceTypes(
        resourceTypes="aemsitetest/components/testcomponent",
        methods= HttpConstants.METHOD_GET,
        selectors = "message",
        extensions="html")
@ServiceDescription("Simple Demo Servlet")
public class DemoServlet extends SlingSafeMethodsServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws IOException {
        resp.getWriter().write(Objects.requireNonNull(req.getResourceResolver()
                .getResource("/content/demoResource"))
                .getValueMap()
                .get("servletMessage").toString());
    }
}