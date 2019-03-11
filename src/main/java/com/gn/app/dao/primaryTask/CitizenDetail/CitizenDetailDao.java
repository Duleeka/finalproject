package com.gn.app.dao.primaryTask.CitizenDetail;

import com.gn.app.model.primaryTask.CitizenDetail.CitizenDetail;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenDetailDao extends DataTablesRepository<CitizenDetail,Integer> {
    /*@Query("select c from CitizenDetail c where c.CFamilyNo=:no")
    CitizenDetail findCitizenDetailById(@Param("no") String  CitizenDetail);*/
}
