package gov.ifms.doi.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.db.entity.TdoiDbPropAviationRiDtlEntity;

public interface TdoiDbPropAviationRiDtlRepository extends JpaRepository<TdoiDbPropAviationRiDtlEntity, Long>,
		JpaSpecificationExecutor<TdoiDbPropAviationRiDtlEntity> {
	@Query("select entity from TdoiDbPropAviationRiDtlEntity entity where entity.activeStatus = 1")
	List<TdoiDbPropAviationRiDtlEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update TdoiDbPropAviationRiDtlEntity entity SET entity.activeStatus = 0 where entity.propAviatRiDtlId = :id")
	void softDeleteById(@Param("id") Long id);

	@Query("select entity from TdoiDbPropAviationRiDtlEntity entity where entity.activeStatus = 1 and entity.propAviatRiDtlId = :id")
	List<TdoiDbPropAviationRiDtlEntity> findAllActiveById(@Param("id") Long id);
}
