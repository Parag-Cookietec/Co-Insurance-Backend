package gov.ifms.doi.hba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiHbaProposalConverter;
import gov.ifms.doi.hba.dto.TdoiHbaProposalDTO;
import gov.ifms.doi.hba.repository.TdoiHbaProposalRepository;
import gov.ifms.doi.hba.service.TdoiHbaProposalService;

@Service
public class TdoiHbaProposalServiceImpl implements TdoiHbaProposalService {

	@Autowired
	TdoiHbaProposalRepository repository;

	@Autowired
	TdoiHbaProposalConverter converter;

	@Override
	public List<TdoiHbaProposalDTO> saveOrUpdate(TdoiHbaProposalDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria();
	}


	@Override
	public List<TdoiHbaProposalDTO> findAllByCriteria() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiHbaProposalDTO> findAllByStatus(TdoiHbaProposalDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiHbaProposalDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}

