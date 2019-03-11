package com.gn.app.dao.primaryTask.CitizenDonation;

import com.gn.app.model.primaryTask.CitizenDonation.CitizenDonation;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenDonationDao extends DataTablesRepository<CitizenDonation,Integer> {
}
