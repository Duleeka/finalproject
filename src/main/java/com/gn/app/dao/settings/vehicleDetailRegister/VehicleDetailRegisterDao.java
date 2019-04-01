package com.gn.app.dao.settings.vehicleDetailRegister;

import com.gn.app.model.Settings.VehicleDetailRegister.VehicleDetailRegister;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by hp on 1/7/2019.
 */
@Repository
public interface VehicleDetailRegisterDao extends DataTablesRepository<VehicleDetailRegister, Integer> {

}
