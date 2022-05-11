package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.CINFileDataDto;
import gov.ifms.gst.entity.CINfileData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GSTFileAccountingConvertor implements BaseConverter<CINfileData, CINFileDataDto> {

	@Override
	public CINfileData toEntity(CINFileDataDto dto) {
		CINfileData entity = new CINfileData();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public CINFileDataDto toDTO(CINfileData entity) {
		CINFileDataDto dto = new CINFileDataDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
