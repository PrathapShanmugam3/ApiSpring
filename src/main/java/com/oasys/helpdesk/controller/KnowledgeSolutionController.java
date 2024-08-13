package com.oasys.helpdesk.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.oasys.helpdesk.dto.KnowledgeSolutionRequestDTO;
import com.oasys.helpdesk.service.KnowledgeSolutionServiceImpl;
import com.oasys.helpdesk.utility.GenericResponse;
import com.oasys.helpdesk.utility.ResponseHeaderUtility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "HelpDeskData", description = "This controller contain all  operation of KnowledgeSolution")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 409, message = "Conflict occurred") })

@RequestMapping("/helpdeskknowledgeSolution")
public class KnowledgeSolutionController {

	@Autowired
	private  KnowledgeSolutionServiceImpl knowledgeService;
		
	@RequestMapping(value = "/addKnowledge", method = RequestMethod.POST)
	@ApiOperation(value = "This api is used to addKnowledgeSolution data", notes = "Returns HTTP 200 if successful get the record")
	public ResponseEntity<Object> createKnowledge(@RequestBody KnowledgeSolutionRequestDTO knowledgeRequestDto) {
		GenericResponse objGenericResponse = knowledgeService.createKnowledge(knowledgeRequestDto);
		return new ResponseEntity<>(objGenericResponse, ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);
	}
	
	@GetMapping("/solutionId")
    @ApiOperation(value = "This api is used to get unique code", notes = "Returns HTTP 200 if successful get the record")
	public ResponseEntity<Object> getCode() throws JsonParseException,ParseException {
		return new ResponseEntity<>(knowledgeService.getCode(), ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);
	}
	@GetMapping("/{getBysolutionId}")
	@ApiOperation(value = "This api is to get typeofuser list by id", notes = "Returns HTTP 200 if successful get the record")
	public ResponseEntity<Object> getBySolutionId(@PathVariable("getBysolutionId") String solutionId) {
		return new ResponseEntity<>(knowledgeService.getBySolutionId(solutionId), ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);
	}
	
}
  