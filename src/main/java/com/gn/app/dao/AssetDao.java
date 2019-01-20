package com.gn.app.dao;

import com.gn.app.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hp on 1/7/2019.
 */
@Repository
public interface AssetDao extends CrudRepository<Asset, Integer> {

}
