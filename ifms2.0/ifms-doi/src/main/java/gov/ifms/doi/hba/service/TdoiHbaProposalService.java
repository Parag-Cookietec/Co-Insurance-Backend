package gov.ifms.doi.hba.service;
import java.util.List;
import gov.ifms.doi.hba.dto.TdoiHbaProposalDTO;
public interface TdoiHbaProposalService{
public List<TdoiHbaProposalDTO> saveOrUpdate(TdoiHbaProposalDTO dto);
public List<TdoiHbaProposalDTO> findAllByCriteria();
public List<TdoiHbaProposalDTO> findAllByStatus(TdoiHbaProposalDTO dto);
public List<TdoiHbaProposalDTO> softDeleteById(Long id);
}
