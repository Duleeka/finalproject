package com.gn.app.dao.settings.RoofDetailRegister;

import com.gn.app.model.Settings.RoofDetailRegister.RoofDetailRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoofDetailRegisterDao extends DataTablesRepository<RoofDetailRegister,Integer> {
}
