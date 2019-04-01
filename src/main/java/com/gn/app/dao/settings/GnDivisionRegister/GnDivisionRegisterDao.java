package com.gn.app.dao.settings.GnDivisionRegister;

import com.gn.app.model.Settings.GnDivisionRegister.GnDivisionRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GnDivisionRegisterDao extends DataTablesRepository<GnDivisionRegister, Integer> {
}
