package gov.ifms.doi.db.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CONTENT_TYPE_APP_JSON;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DB_BASE_URL;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DB_POLFIREBUILDINGVAL_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DB_POLFIREBUILDINGVAL_LISTING;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DB_POLFIREBUILDINGVAL_LISTING_BY_STATUS;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DB_POLFIREBUILDINGVAL_DELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.db.dto.TdoiDbPolFireBuildingValDTO;
import gov.ifms.doi.db.service.TdoiDbPolFireBuildingValService;


@RestController
@RequestMapping(DOI_JPA_DB_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TdoiDbPolFireBuildingValController{

	@Autowired
	TdoiDbPolFireBuildingValService service;


	@Trace
	@PostMapping(value =DOI_JPA_DB_POLFIREBUILDINGVAL_ENTRY , produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdate(@RequestBody TdoiDbPolFireBuildingValDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdate(dto));
	}


	@Trace
	@PostMapping(value = DOI_JPA_DB_POLFIREBUILDINGVAL_LISTING, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAll(@RequestBody TdoiDbPolFireBuildingValDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByCriteria(dto));
	}


	@Trace
	@DeleteMapping(value = DOI_JPA_DB_POLFIREBUILDINGVAL_DELETE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> softDeleteById(@RequestParam(name = "id") Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE, service.softDeleteById(id));
	}


	@Trace
	@PostMapping(value = DOI_JPA_DB_POLFIREBUILDINGVAL_LISTING_BY_STATUS, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllByStatus(@RequestBody TdoiDbPolFireBuildingValDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByStatus(dto));
	}

}

