package com.aemsitetest.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

@Model(adaptables = Resource.class)
public class DemoModel {

    @ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy= InjectionStrategy.OPTIONAL)
    @Default(values="No resourceType")
    protected String message;

    @SlingObject
    private Resource currentResource;

    @PostConstruct
    protected void init() {
        if (currentResource != null) {
            message = currentResource.getValueMap().get("message", message.getClass());
        }
    }

    public String getMessage() {
        return message;
    }

}
