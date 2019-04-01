package com.gn.app.dao.administrativeTask.GnProfile;

import com.gn.app.model.administrativeTask.GnProfile.GnProfile;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by hp on 1/7/2019.
 */
@Repository
public interface GnProfileDao extends DataTablesRepository<GnProfile, Integer> {

}
