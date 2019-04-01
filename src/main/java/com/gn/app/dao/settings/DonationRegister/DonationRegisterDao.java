package com.gn.app.dao.settings.DonationRegister;

import com.gn.app.model.Settings.DonationRegister.DonationRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRegisterDao extends DataTablesRepository<DonationRegister,Integer> {
}
