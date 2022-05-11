package gov.ifms.doi.hba.service;
import java.util.List;
import gov.ifms.doi.hba.dto.TdoiHbaClaimEntryDTO;
public interface TdoiHbaClaimEntryService{
public List<TdoiHbaClaimEntryDTO> saveOrUpdate(TdoiHbaClaimEntryDTO dto);
public List<TdoiHbaClaimEntryDTO> findAllByCriteria();
public List<TdoiHbaClaimEntryDTO> findAllByStatus(TdoiHbaClaimEntryDTO dto);
public List<TdoiHbaClaimEntryDTO> softDeleteById(Long id);
}
