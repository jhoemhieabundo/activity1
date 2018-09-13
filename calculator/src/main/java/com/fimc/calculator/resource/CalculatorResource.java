package com.fimc.calculator.resource;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/calculator")
public class CalculatorResource {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response calculate(CalculatorRequest request) {
		if(request.getOperator().isEmpty() || request.getNumber1().equals(null) || !request.getNumber1().matches("[0-9]+")
				|| !request.getNumber2().matches("[0-9]+")) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();
		}
		DecimalFormat df = new DecimalFormat("#.#####");
		CalculatorResponse calculatorResponse = new CalculatorResponse();
		
		
		switch(request.getOperator()) {
		case "+":
			calculatorResponse.setAction("Addition");
			calculatorResponse.setResult(Double.parseDouble(request.getNumber1()) + Double.parseDouble(request.getNumber2()));
			break;
		case "-":
			calculatorResponse.setAction("Subtraction");
			calculatorResponse.setResult(Double.parseDouble(request.getNumber1()) - Double.parseDouble(request.getNumber2()));
			break;
		case "*":
			calculatorResponse.setAction("Multiplication");
			calculatorResponse.setResult(Double.parseDouble(request.getNumber1()) * Double.parseDouble(request.getNumber2()));
			break;
		case "/":
			if(Double.parseDouble(request.getNumber2()) == 0) {
				return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();
			}
			calculatorResponse.setAction("Division");
			calculatorResponse.setResult(Double.parseDouble(request.getNumber1()) / Double.parseDouble(request.getNumber2()));
			break;
		default:
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();
			
		}
			
		
		
		
		return Response.ok().entity(calculatorResponse).build();
	}

}
