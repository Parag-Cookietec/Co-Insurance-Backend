package gov.ifms.dmo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMODeparmentMinsistryDto;
import gov.ifms.dmo.service.DMODeparmentMinistryService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.DMO_DEPARMENT_MINISTRY_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMODeparmentMinsistryController {
	@Autowired
	DMODeparmentMinistryService service;
	
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> deparmentMinistrylisting(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.deparmentMinistrylisting(pageDetail));
	}
	
	@Trace
	@PostMapping(DMOURLConstant.URL_POST)
	public ResponseEntity<ApiResponse> saveorUpdate(@Valid @RequestBody DMODeparmentMinsistryDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.save(dto));
	}
	


}
