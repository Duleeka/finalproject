package com.gn.app.dao.citizenProfileTask.DeathDetail;

import com.gn.app.model.citizenProfileTask.DeathDetail.DeathDetail;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeathDetailDao extends DataTablesRepository<DeathDetail,Integer> {
}
