package com.gn.app.dao.citizenProfileTask.DonationDetail;

import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetail;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationDetailDao extends DataTablesRepository<DonationDetail, Integer> {
}
