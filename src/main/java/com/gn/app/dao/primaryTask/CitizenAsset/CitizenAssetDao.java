package com.gn.app.dao.primaryTask.CitizenAsset;

import com.gn.app.model.primaryTask.CitizenAsset.CitizenAsset;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenAssetDao extends DataTablesRepository<CitizenAsset, Integer> {
}
