package com.gn.app.service.AdministrativeTask.GnProfile;

import com.gn.app.dto.administrativeTask.GnProfile.GnProfileDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

/**
 * Created by hp on 1/7/2019.
 */
public interface GnProfileService {


    DataTablesOutput<GnProfileDTO> findAllDataTable(DataTablesInput input);

    List<GnProfileDTO> findAll();

    GnProfileDTO create(GnProfileDTO gnProfile);

    GnProfileDTO findById(Integer id);

    void delete(Integer id);




}
