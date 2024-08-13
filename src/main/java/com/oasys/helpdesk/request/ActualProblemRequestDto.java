package com.oasys.helpdesk.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActualProblemRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7556535340883131007L;

	private Long id;
	
	@NotBlank(message = "103")
	private String actualproblem;
	
	@NotBlank(message = "103")
	private String code;
	
	@NotNull(message = "103")
    private boolean isActive;
	
	private Long createdBy;
	
	private Long modifiedBy;
	
	@NotNull(message = "103")
	private Long categoryId;

	@NotNull(message = "103")
	private Long subCategoryId;
	
	
	
}
