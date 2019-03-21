package com.gn.app.dao.settings.LandDetailRegister;

import com.gn.app.model.Settings.LandDetailRegister.LandDetailRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandDetailRegisterDao extends DataTablesRepository<LandDetailRegister,Integer> {
}
