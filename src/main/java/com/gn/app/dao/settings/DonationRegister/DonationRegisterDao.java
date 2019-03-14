package com.gn.app.dao.settings.DonationRegister;

import com.gn.app.model.Settings.DonationRegister.DonationRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface DonationRegisterDao extends DataTablesRepository<DonationRegister,Integer> {
}
