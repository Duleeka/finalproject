package com.gn.app.dao.settings.NationalityRegister;


import com.gn.app.model.Settings.NationalityRegister.NationalityRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalityRegisterDao extends DataTablesRepository<NationalityRegister, Integer> {
}
