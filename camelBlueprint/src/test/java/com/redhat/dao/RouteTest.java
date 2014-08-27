package com.redhat.dao;

import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

import com.redhat.model.TestModel;

public class RouteTest extends CamelBlueprintTestSupport {
	
	@Override
	protected void doPreSetup() throws Exception {
		System.setProperty("org.apache.aries.blueprint.synchronous", Boolean.TRUE.toString());
		super.doPreSetup();
	}

    @EndpointInject(uri = "direct:start")
    protected Endpoint inEndpoint;

    @Override
    protected String getBlueprintDescriptor() {
        return  "OSGI-INF/blueprint/config-properties.xml," +
                "OSGI-INF/blueprint/camelTestRoute.xml";
    }

    @Test
    public void testPersist() throws Exception {
        template.sendBody(inEndpoint, new TestModel());

        Thread.sleep(2000);
    }
}
