package com.gn.app.dao.settings.ServiceRegister;

import com.gn.app.model.Settings.ServiceRegister.ServiceRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRegisterDao extends DataTablesRepository<ServiceRegister, Integer> {
}
