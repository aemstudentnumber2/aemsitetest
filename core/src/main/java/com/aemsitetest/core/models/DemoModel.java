package com.aemsitetest.core.models;

import com.aemsitetest.core.services.ComponentTitleChange;
import org.apache.sling.api.resource.*;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.*;

import javax.annotation.PostConstruct;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

@Model(adaptables = Resource.class)
public class DemoModel {

    @ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy= InjectionStrategy.OPTIONAL)
    @Default(values="No resourceType")
    protected String message;
    @ValueMapValue(name="text", injectionStrategy= InjectionStrategy.OPTIONAL)
    @Default(values="No resourceType")
    protected String title;

    @SlingObject
    private Resource currentResource;
    @OSGiService
    ComponentTitleChange componentTitleChange;

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    @PostConstruct
    protected void init() {
        if (currentResource != null) {
            message = currentResource.getValueMap().get("message", message.getClass());
            title = componentTitleChange.giveTitlePathForMergingAndGetItBack(title, currentResource.getPath());
        }
    }
}