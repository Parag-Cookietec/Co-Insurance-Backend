package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.GSTAccountHdr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface GSTAccountHdrRepository
		extends JpaRepository<GSTAccountHdr, Long>, JpaSpecificationExecutor<GSTAccountHdr>, GenericDao {

	GSTAccountHdr findByCinNo(String cinNo);

}
