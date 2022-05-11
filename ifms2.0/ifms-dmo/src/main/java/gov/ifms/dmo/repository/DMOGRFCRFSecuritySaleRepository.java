package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.entity.DMOGRFCRFSecuritySaleEntity;

@Repository
@Transactional
public interface DMOGRFCRFSecuritySaleRepository extends JpaRepository<DMOGRFCRFSecuritySaleEntity, Long>,
		JpaSpecificationExecutor<DMOGRFCRFSecuritySaleEntity> {

}
