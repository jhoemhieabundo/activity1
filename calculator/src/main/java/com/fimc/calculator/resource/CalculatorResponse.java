package com.fimc.calculator.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CalculatorResponse implements Serializable{
	
	private String action;
	private Double result;

}
