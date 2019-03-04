package com.gn.app.service;

import com.gn.app.dao.AssetDao;
import com.gn.app.model.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hp on 1/7/2019.
 */
@Service
public class AssetServiceImpl implements AssetService {


  // @Autowired
  //  AssetDao assetDao;

    @Override
    public void create(Asset asset) {
  //  assetDao.save(asset);
    }
}
