package com.fimc.people.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleResponse implements Serializable{
	
 private String fname;
 private String lname;
 private String bdate;

}
