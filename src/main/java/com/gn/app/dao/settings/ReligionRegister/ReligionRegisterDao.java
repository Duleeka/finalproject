package com.gn.app.dao.settings.ReligionRegister;


import com.gn.app.model.Settings.ReligionRegister.ReligionRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReligionRegisterDao extends DataTablesRepository<ReligionRegister, Integer> {
}
