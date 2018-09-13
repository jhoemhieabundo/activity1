package com.fimc.calculator;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import com.fimc.calculator.resource.CalculatorResource;

@Component
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig() {
		register(CalculatorResource.class);
		property(ServletProperties.FILTER_FORWARD_ON_404,true);
	}
	
}
