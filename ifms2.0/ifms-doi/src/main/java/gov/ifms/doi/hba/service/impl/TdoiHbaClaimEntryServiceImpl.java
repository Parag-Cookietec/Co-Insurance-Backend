package gov.ifms.doi.hba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiHbaClaimEntryConverter;
import gov.ifms.doi.hba.dto.TdoiHbaClaimEntryDTO;
import gov.ifms.doi.hba.repository.TdoiHbaClaimEntryRepository;
import gov.ifms.doi.hba.service.TdoiHbaClaimEntryService;

@Service
public class TdoiHbaClaimEntryServiceImpl implements TdoiHbaClaimEntryService {

	@Autowired
	TdoiHbaClaimEntryRepository repository;

	@Autowired
	TdoiHbaClaimEntryConverter converter;

	@Override
	public List<TdoiHbaClaimEntryDTO> saveOrUpdate(TdoiHbaClaimEntryDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria();
	}


	@Override
	public List<TdoiHbaClaimEntryDTO> findAllByCriteria() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiHbaClaimEntryDTO> findAllByStatus(TdoiHbaClaimEntryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiHbaClaimEntryDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}

