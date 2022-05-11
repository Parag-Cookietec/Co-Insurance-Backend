package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbClaimPrevLossEntity;

public interface TdoiDbClaimPrevLossRepository
		extends JpaRepository<TdoiDbClaimPrevLossEntity, Long>, JpaSpecificationExecutor<TdoiDbClaimPrevLossEntity> {
	@Query("select entity from TdoiDbClaimPrevLossEntity entity where entity.activeStatus = 1")
	List<TdoiDbClaimPrevLossEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbClaimPrevLossEntity entity SET entity.activeStatus = 0 where entity.prevLossId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbClaimPrevLossEntity entity where entity.activeStatus = 1 and entity.prevLossId = :id")
	List<TdoiDbClaimPrevLossEntity> findAllActiveById(@Param("id") Long id);
}
