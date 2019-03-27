package com.gn.app.dao.settings.EducationLevelRegister;

import com.gn.app.model.Settings.EducationLevelRegister.EducationLevelRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationLevelRegisterDao extends DataTablesRepository<EducationLevelRegister,Integer> {
}
