package gov.ifms.doi.coinsurance.service.impl;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.doi.coinsurance.converter.DoiCoInsuranceConverter;
import gov.ifms.doi.coinsurance.dto.*;
import gov.ifms.doi.coinsurance.entity.*;
import gov.ifms.doi.coinsurance.repository.*;
import gov.ifms.doi.coinsurance.service.DoiCoInsuranceService;
import gov.ifms.doi.jpa.constant.DoiDBConstants;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.jpa.pagination.SearchCriteria;
import gov.ifms.doi.jpa.pagination.SearchParam;
import gov.ifms.doi.jpa.pagination.SpecificationImplimentation;
import gov.ifms.gst.repository.RBIFileTranxnRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Rudra
 *
 */
@Service
public class DoiCoInsuranceServiceImpl implements DoiCoInsuranceService {

	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	DoiCoinsChequeRegisterRepository chequeRegRepo;
	
	@Autowired
	DoiCoinsPremiumRegisterRepository premiumRegRepo;
	
	@Autowired
	DoiCoinsClaimRepository claimRepo;
	
	@Autowired
	DoiCoinsClaimRiDtlRepository claimRiDtlRepo;
	
	@Autowired
	DoiCoinsPolicyRepository policyRepo;
	
	@Autowired
	DoiCoinsPolicyRiDtlsRepository policyRiDtlsRepo;
	
	@Autowired
	DoiCoinsPremiumRefundRepository premiumRefundRepo;
	
	@Autowired
	DoiCoInsuranceConverter converter;

	@Autowired
	private RBIFileTranxnRepository rbiFileTranxnRepository;
	
	@Override
	public DoiCoinsChequeRegisterDTO saveOrUpdateCoinsChequeRegister(DoiCoinsChequeRegisterDTO dto) {
		chequeRegRepo.save(converter.toCoinsChequeRegisterEntity(dto));
		DoiCoinsChequeRegisterDTO rdto = dto;
		return rdto;
	}

	@Override
	public PagebleDTO<DoiCoinsChequeRegisterDTO> getCoinsChequeRegisterListing(PageDetails pageDetail) throws CustomException {
	adjustDateFilterForChequeRegisterListing(pageDetail);
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImplimentation<DoiCoinsChequeRegisterEntity> spec = new SpecificationImplimentation<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DoiCoinsChequeRegisterEntity> dataSpec = searchCriteria.getSpecificationDetailsDynamic(spec, pageDetail.getJsonArr());
	        Page<DoiCoinsChequeRegisterEntity> page = chequeRegRepo.findAll(dataSpec, pageable);
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toCoinsChequeRegisterDTOList(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private static void adjustDateFilterForChequeRegisterListing(PageDetails pageDetails){
		Optional<SearchParam> createdDate = pageDetails.getJsonArr().stream().filter(s -> s.getKey().equals("createdDate")).findFirst();
		if(createdDate.isPresent()){
			SearchParam createdDateParam = createdDate.get();
			LocalDate currentDate = LocalDate.parse(createdDateParam.getValue(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			LocalDate nextDay=currentDate.plusDays(1);
			LocalDate prevDay=currentDate.minusDays(1);
			String nextDayStr = nextDay.getDayOfMonth()+"/"+nextDay.getMonthValue()+"/"+nextDay.getYear();
			String prevDayStr = prevDay.getDayOfMonth()+"/"+prevDay.getMonthValue()+"/"+prevDay.getYear();
			createdDateParam.setValue(prevDayStr);
			createdDateParam.setOperation(">");
			pageDetails.getJsonArr().add(new SearchParam(createdDateParam.getKey(),nextDayStr,"<"));
		}
	}

	@Override
	public DoiCoinsPremiumRegisterDTO getAndSaveCoinsPremiumRegister(DoiCoinsPremiumRegisterDTO dto) {
		premiumRegRepo.save(converter.toCoinsPremiumRegisterEntity(dto));
		DoiCoinsPremiumRegisterDTO rdto = dto;
		return rdto;
	}

	@Override
	public DoiCoinsPolicyHdrDTO saveOrUpdateCoinsPolicyMaster(DoiCoinsPolicyHdrDTO dto) {
		DoiCoinsPolicyHdrEntity policyHdrEntity = policyRepo.save(converter.toCoinsPolicyHdrEntity(dto));
		for (DoiCoinsPolicyRiEntity policyRiEntity : converter.toCoinsPolicyRiList(dto.getDoiCoinsPolicyRi())) {
			policyRiEntity.setDoiCoinsPolicyHdrEntity(policyHdrEntity);
			policyRiDtlsRepo.save(policyRiEntity);
		}
		DoiCoinsPolicyHdrDTO rdto = dto ;
		return rdto;
	}

	@Override
	public PagebleDTO<DoiCoinsPolicyHdrDTO> getCoinsPolicyListing(PageDetails pageDetail) throws CustomException {
		adjustMonthAndYearFilterForPolicyAndPremiumRefundListing(pageDetail);
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImplimentation<DoiCoinsPolicyHdrEntity> spec = new SpecificationImplimentation<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DoiCoinsPolicyHdrEntity> dataSpec = searchCriteria.getSpecificationDetailsDynamic(spec, pageDetail.getJsonArr());
	        Page<DoiCoinsPolicyHdrEntity> page = policyRepo.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toCoinsPolicyListing(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private void adjustMonthAndYearFilterForPolicyAndPremiumRefundListing(PageDetails pageDetails) {
		Optional<SearchParam> month = pageDetails.getJsonArr().stream().filter(s -> s.getKey().equals("month")).findFirst();
		Optional<SearchParam> year = pageDetails.getJsonArr().stream().filter(s -> s.getKey().equals("year")).findFirst();
		boolean isMonthAndYearFilterAvailable = false;
		if(month.isPresent() && year.isPresent()){
			isMonthAndYearFilterAvailable = true;
			LocalDate firstDayOfMonth = LocalDate.of(Integer.parseInt(year.get().getValue()),Integer.parseInt(month.get().getValue()),1);
			LocalDate firstDayOfNextMonth = firstDayOfMonth.plusMonths(1);
			String nextDayStr = firstDayOfNextMonth.getDayOfMonth()+"/"+firstDayOfNextMonth.getMonthValue()+"/"+firstDayOfNextMonth.getYear();
			String prevDayStr = firstDayOfMonth.getDayOfMonth()+"/"+firstDayOfMonth.getMonthValue()+"/"+firstDayOfMonth.getYear();
			pageDetails.getJsonArr().add(new SearchParam("createdDate",prevDayStr,">="));
			pageDetails.getJsonArr().add(new SearchParam("createdDate",nextDayStr,"<"));
		}
		if(isMonthAndYearFilterAvailable){
			int monthArrayIndex = -1;
			int yearArrayIndex = -1;
			for(int i=0;i<pageDetails.getJsonArr().size();i++){
				if(monthArrayIndex == -1 && pageDetails.getJsonArr().get(i).getKey().equals("month")){
					monthArrayIndex = i;
				}
				if(yearArrayIndex == -1 && pageDetails.getJsonArr().get(i).getKey().equals("month")){
					yearArrayIndex = i;
				}
			}
			pageDetails.getJsonArr().remove(monthArrayIndex);
			pageDetails.getJsonArr().remove(yearArrayIndex);
		}
	}

	@Override
	public PagebleDTO<DoiCoinsPremiumRefundDTO> saveOrUpdateCoinsPremiumRefundEntry(DoiCoinsPremiumRefundDTO dto) throws CustomException {
		premiumRefundRepo.save(converter.toCoinsPremiumRefundEntity(dto));
		
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(5);
		pageDetail.setPageIndex(0);
		pageDetail.setSortByColumn("coinsPremRefundId");
		pageDetail.setSortOrder("asc");
		pageDetail.setJsonArr(new ArrayList<SearchParam>());
		return getCoinsPremiumRefundListing(pageDetail );
	}

	@Override
	public PagebleDTO<DoiCoinsPremiumRefundDTO> getCoinsPremiumRefundListing(PageDetails pageDetail) throws CustomException {
		adjustMonthAndYearFilterForPolicyAndPremiumRefundListing(pageDetail);
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImplimentation<DoiCoinsPremiumRefundEntity> spec = new SpecificationImplimentation<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DoiCoinsPremiumRefundEntity> dataSpec = searchCriteria.getSpecificationDetailsDynamic(spec, pageDetail.getJsonArr());
	        Page<DoiCoinsPremiumRefundEntity> page = premiumRefundRepo.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toCoinsPremiumRefundList(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public DoiCoinsClaimHdrDTO saveOrUpdateCoinsClaimEntry(DoiCoinsClaimHdrDTO dto) {
		DoiCoinsClaimHdrEntity claimHdrEntity = claimRepo.save(converter.toCoinsClaimHdrEntity(dto));
		for (DoiCoinsClaimRiDtlEntity claimRiEntity : converter.toCoinsClaimRiList(dto.getDoiCoinsClaimRiDtl())) {
			claimRiEntity.setDoiCoinsClaimHdrEntity(claimHdrEntity);
			claimRiDtlRepo.save(claimRiEntity);
		}
		
		DoiCoinsClaimHdrDTO rdto = dto ;
		return rdto;
	}

	@Override
	public PagebleDTO<DoiCoinsClaimHdrDTO> getCoinsClaimEntryListing(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImplimentation<DoiCoinsClaimHdrEntity> spec = new SpecificationImplimentation<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DoiCoinsClaimHdrEntity> dataSpec = searchCriteria.getSpecificationDetailsDynamic(spec, pageDetail.getJsonArr());
	        Page<DoiCoinsClaimHdrEntity> page = claimRepo.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toCoinsClaimEntryListing(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public List<DoiCoinsClaimHdrDTO> findAllClaimDetails() {
		// TODO Auto-generated method stub
		return converter.toClaimDtofromEntity(claimRepo.findAll());
	}

	@Override
	public PagebleDTO<DoiCoinsPolicyHdrDTO> getPolicyEntryListing(PageDetails pageDetail) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(DoiDBConstants.getPolicyEntryListing().get(search.getKey()),
					search.getValue()));
		}
		DoiDBConstants.getPolicyEntryListing()
				.entrySet().stream()
				.filter(e -> !map.containsKey(e.getValue()))
				.forEach(e -> map.put(e.getValue(),null));
		String procName = DoiDBConstants.DOI_SCHEMA.concat(Constant.DOT.concat(DoiDBConstants.SP_TDOI_COINS_POLICY_HDR_LISTING));
		List<DoiCoinsPolicyHdrDTO> objectSp = null;
		try {
			objectSp = this.callStoreProc(procName, map, DoiCoinsPolicyHdrDTO.class);
		} catch (CustomException e1) {
			e1.printStackTrace();
		}
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	@Override
	public PagebleDTO<DoiCoinsPremiumRefundDTO> getPremiumRefundEntryListing(PageDetails pageDetail) {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
			map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
			List<SearchParam> searchParams = pageDetail.getJsonArr();
			if (searchParams != null && !searchParams.isEmpty()) {
				searchParams.forEach(search -> map.put(DoiDBConstants.getPremiumRefundEntryListing().get(search.getKey()),
						search.getValue()));
			}
			DoiDBConstants.getPremiumRefundEntryListing()
					.entrySet().stream()
					.filter(e -> !map.containsKey(e.getValue()))
					.forEach(e -> map.put(e.getValue(),null));
			String procName = DoiDBConstants.DOI_SCHEMA.concat(Constant.DOT.concat(DoiDBConstants.SP_TDOI_COINS_PREMIUM_REFUND_LISTING));
			List<DoiCoinsPremiumRefundDTO> objectSp = null;
			try {
				objectSp = this.callStoreProc(procName, map, DoiCoinsPremiumRefundDTO.class);
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
			long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	@Override
	public PagebleDTO<DoiCoinsClaimHdrDTO> getClaimListing(PageDetails pageDetail) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(DoiDBConstants.getClaimListing().get(search.getKey()),
					search.getValue()));
		}
		DoiDBConstants.getClaimListing()
				.entrySet().stream()
				.filter(e -> !map.containsKey(e.getValue()))
				.forEach(e -> map.put(e.getValue(),null));
		String procName = DoiDBConstants.DOI_SCHEMA.concat(Constant.DOT.concat(DoiDBConstants.SP_TDOI_COINS_CLAIM_HDR_LISTING));
		List<DoiCoinsClaimHdrDTO> objectSp = null;
		try {
			objectSp = this.callStoreProc(procName, map, DoiCoinsClaimHdrDTO.class);
		} catch (CustomException e1) {
			e1.printStackTrace();
		}
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	/**
	 * Call store proc.
	 *
	 * @param <T>      the generic type
	 * @param procName the proc name
	 * @param map      the map
	 * @param view     the view
	 *
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private <T> List<T> callStoreProc(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectSp = rbiFileTranxnRepository.callStoredProcedure(procName, map);
		return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
	}
	
}
