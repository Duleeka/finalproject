package com.gn.app.dao.citizenProfileTask.CitizenDetail;

import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenDetailDao extends DataTablesRepository<CitizenDetail, Integer> {
    /*@Query("select c from CitizenDetail c where c.CFamilyNo=:no")
    CitizenDetail findCitizenDetailById(@Param("no") String  CitizenDetail);*/
}
