package com.gn.app.dao.settings.WallDetailRegister;

import com.gn.app.model.Settings.WallDetailRegister.WallDetailRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WallDetailRegisterDao extends DataTablesRepository<WallDetailRegister, Integer> {
}
