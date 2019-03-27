package com.gn.app.dao.settings.FloorDetailRegister;

import com.gn.app.model.Settings.FloorDetailRegister.FloorDetailRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorDetailRegisterDao extends DataTablesRepository<FloorDetailRegister,Integer> {
}
