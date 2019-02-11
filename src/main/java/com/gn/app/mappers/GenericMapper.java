package com.gn.app.mappers;

import java.util.ArrayList;
import java.util.List;

import com.gn.app.dto.BaseDTO;
import com.gn.app.model.BaseModel;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;


public abstract class GenericMapper<DOMAIN extends BaseModel, DTO extends BaseDTO> {

	/**
	 * Transform domain object into DTO
	 * Mappings are used to 'bind' entity fields to DTO fields (for the mapper's implementation).
	 * @param domain
	 * @return DTO
	 */
	public abstract DTO domainToDto(DOMAIN domain) throws Exception;

	/**
	 * Transform domain object into Data Table DTO
	 * Mappings are used to 'bind' entity fields to DTO fields (for the mapper's implementation).
	 * @param domain
	 * @return DTO
	 */
	public abstract DTO domainToDtoForDataTable(DOMAIN domain) throws Exception;

	/**
	 * Transform dto to domain
	 * @param domain
	 * @param dto
	 */
	public abstract void dtoToDomain(DTO dto, DOMAIN domain) throws Exception;

	public List<DTO> domainToDTOList(final Iterable<? extends DOMAIN> domainList) throws Exception{
		if(domainList == null) {
			return new ArrayList<>();
		}
		final List<DTO> dtoList = new ArrayList<>();

		for(final DOMAIN domain : domainList){
			dtoList.add(domainToDto(domain));
		}
		return dtoList;
	}

	public List<DTO> domainToDTOListForDataTables(final Iterable<? extends DOMAIN> domainList) throws Exception{
		if(domainList == null) {
			return new ArrayList<>();
		}
		final List<DTO> dtoList = new ArrayList<>();

		for(final DOMAIN domain : domainList){
			dtoList.add(domainToDtoForDataTable(domain));
		}
		return dtoList;
	}

	public DataTablesOutput<DTO> domainToDTODataTablesOutput(final DataTablesOutput<? extends DOMAIN> domainOut) throws Exception {
		final DataTablesOutput<DTO> out = new DataTablesOutput<>();
		out.setData(domainToDTOListForDataTables(domainOut.getData()));
		out.setDraw(domainOut.getDraw());
		out.setError(domainOut.getError());
		out.setRecordsFiltered(domainOut.getRecordsFiltered());
		out.setRecordsTotal(domainOut.getRecordsTotal());
		return out;

	}

	protected void setCommanDTOFields(final DTO dto, final DOMAIN domain) {
		dto.setIsDeleted(domain.getIsDeleted());
		dto.setVersion(domain.getVersion());
	}

	protected void setCommanDomainFields(final DTO dto, final DOMAIN domain) {
		domain.setIsDeleted(dto.getIsDeleted());
		domain.setVersion(dto.getVersion());
	}
}
