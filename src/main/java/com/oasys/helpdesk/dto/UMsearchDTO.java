package com.oasys.helpdesk.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class UMsearchDTO implements Serializable {
	
	 private String userName;
		
	 private String password;
	 
	 private String search;
	 
	 private String source;
	 
     private String userId;
     
	 private String shopId;
	 

}
