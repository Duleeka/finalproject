package com.gn.app.service.primaryTask.CitizenAsset;

import com.gn.app.dao.citizenProfileTask.CitizenDetail.CitizenDetailDao;
import com.gn.app.dao.primaryTask.CitizenAsset.CitizenAssetDao;
import com.gn.app.dao.settings.FloorDetailRegister.FloorDetailRegisterDao;
import com.gn.app.dao.settings.LandDetailRegister.LandDetailRegisterDao;
import com.gn.app.dao.settings.RoofDetailRegister.RoofDetailRegisterDao;
import com.gn.app.dao.settings.WallDetailRegister.WallDetailRegisterDao;
import com.gn.app.dto.primaryTask.CitizenAsset.CitizenAssetDTO;
import com.gn.app.mappers.primaryTask.CitizenAsset.CitizenAssetMapper;
import com.gn.app.model.Settings.FloorDetailRegister.FloorDetailRegister;
import com.gn.app.model.Settings.LandDetailRegister.LandDetailRegister;
import com.gn.app.model.Settings.RoofDetailRegister.RoofDetailRegister;
import com.gn.app.model.Settings.WallDetailRegister.WallDetailRegister;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;
import com.gn.app.model.primaryTask.CitizenAsset.CitizenAsset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenAssetServiceImpl implements CitizenAssetService {

   @Autowired
   CitizenAssetDao citizenAssetDao;
   
   @Autowired
    CitizenDetailDao citizenDetailDao;
   
   @Autowired
    LandDetailRegisterDao landDetailRegisterDao;

   @Autowired
    WallDetailRegisterDao wallDetailRegisterDao;

   @Autowired
    RoofDetailRegisterDao roofDetailRegisterDao;

   @Autowired
    FloorDetailRegisterDao floorDetailRegisterDao;


    @Override
    public DataTablesOutput<CitizenAssetDTO> findAllDataTable (DataTablesInput input) {

        DataTablesOutput<CitizenAsset> output= citizenAssetDao.findAll(input);
        DataTablesOutput<CitizenAssetDTO> dataTablesOutput=null;
        try{
            dataTablesOutput = CitizenAssetMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<CitizenAssetDTO> findAll() {
        List<CitizenAssetDTO> profiles = null;
        try{
            profiles = CitizenAssetMapper.getInstance().domainToDTOList(citizenAssetDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public CitizenAssetDTO create(CitizenAssetDTO citizenAssetDTO) {


        if(citizenAssetDTO.getId() != null){
            return update(citizenAssetDTO);
        }else{
            return save(citizenAssetDTO);
        }


    }


    private CitizenAssetDTO update(CitizenAssetDTO citizenAssetDTO){
        CitizenAsset citizenAsset= findByIdEntity(citizenAssetDTO.getId()).get();

        try {
            CitizenAssetMapper.getInstance().dtoToDomain(citizenAssetDTO,citizenAsset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(citizenAsset);
        return citizenAssetDTO;
    }
    private CitizenAssetDTO  save(CitizenAssetDTO citizenAssetDTO){
        CitizenAsset citizenAsset=new CitizenAsset();
        try {
            CitizenAssetMapper.getInstance().dtoToDomain(citizenAssetDTO,citizenAsset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setCommonData(citizenAsset, citizenAssetDTO);
        saveOrUpdate(citizenAsset);
        return citizenAssetDTO;
    }

    private void setCommonData(CitizenAsset citizenAsset, CitizenAssetDTO citizenAssetDTO) {
        setCitizen(citizenAsset, citizenAssetDTO);
        setLandDetailRegister(citizenAsset, citizenAssetDTO);
        setRoofDetailRegister(citizenAsset, citizenAssetDTO);
        setFloorDetailRegister(citizenAsset, citizenAssetDTO);
        setWallDetailRegister(citizenAsset, citizenAssetDTO);
    }

    private void setCitizen(CitizenAsset citizenAsset, CitizenAssetDTO citizenAssetDTO) {

        if(citizenAssetDTO != null && citizenAssetDTO.getCitizenId()!=null) {

            citizenAsset.setCitizenDetail(citizenDetailDao.findOne(findCitizenSpecification
                    (citizenAssetDTO.getCitizenId())).get());
        }}

    private Specification<CitizenDetail> findCitizenSpecification(Integer citizenId) {
        Specification<CitizenDetail> specification=new Specification<CitizenDetail>() {
            @Override
            public Predicate toPredicate(Root<CitizenDetail> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), citizenId);
            }
        };
        return specification;
    }

    private void setWallDetailRegister(CitizenAsset citizenAsset, CitizenAssetDTO citizenAssetDTO) {
        if (citizenAssetDTO != null && citizenAssetDTO.getWallId() != null) {
            citizenAsset.setWallDetailRegister(wallDetailRegisterDao.findOne(findWallDetailRegisterSpecification
                    (citizenAssetDTO.getWallId())).get());
        }
    }
    private Specification<WallDetailRegister> findWallDetailRegisterSpecification(Integer wallId) {
        Specification<WallDetailRegister> specification = new Specification<WallDetailRegister>() {
            @Override
            public Predicate toPredicate(Root<WallDetailRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"),wallId);
            }
        };
        return  specification;
    }

    private void setFloorDetailRegister(CitizenAsset citizenAsset, CitizenAssetDTO citizenAssetDTO) {
        if (citizenAssetDTO != null && citizenAssetDTO.getFloorId() != null) {
            citizenAsset.setFloorDetailRegister(floorDetailRegisterDao.findOne(findFloorDetailRegisterSpecification
                    (citizenAssetDTO.getFloorId())).get());
        }
    }
    private Specification<FloorDetailRegister> findFloorDetailRegisterSpecification(Integer floorId) {
        Specification<FloorDetailRegister> specification = new Specification<FloorDetailRegister>() {
            @Override
            public Predicate toPredicate(Root<FloorDetailRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"),floorId);
            }
        };
        return  specification;
    }


    private void setRoofDetailRegister(CitizenAsset citizenAsset, CitizenAssetDTO citizenAssetDTO) {
        if (citizenAssetDTO != null && citizenAssetDTO.getRoofId() != null) {
            citizenAsset.setRoofDetailRegister(roofDetailRegisterDao.findOne(findRoofDetailRegisterSpecification
                    (citizenAssetDTO.getRoofId())).get());
        }
    }
    private Specification<RoofDetailRegister> findRoofDetailRegisterSpecification(Integer roofId) {
        Specification<RoofDetailRegister> specification = new Specification<RoofDetailRegister>() {
            @Override
            public Predicate toPredicate(Root<RoofDetailRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"),roofId);
            }
        };
        return specification;
    }


    private void setLandDetailRegister(CitizenAsset citizenAsset, CitizenAssetDTO citizenAssetDTO) {

        if(citizenAssetDTO != null && citizenAssetDTO.getLandId()!=null) {

        citizenAsset.setLandDetailRegister(landDetailRegisterDao.findOne(findLandDetailRegisterSpecification
                (citizenAssetDTO.getLandId())).get());
    }}

    private Specification<LandDetailRegister> findLandDetailRegisterSpecification(Integer landId) {
        Specification<LandDetailRegister> specification = new Specification<LandDetailRegister>() {
            @Override
            public Predicate toPredicate(Root<LandDetailRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"),landId);
            }
        };
        return specification;
    }

    private void saveOrUpdate(CitizenAsset citizenAsset){
        citizenAssetDao.save(citizenAsset);
    }

    @Override
    public CitizenAssetDTO findById(Integer id) {
        CitizenAsset citizenAsset=findByIdEntity(id).get();
        CitizenAssetDTO citizenAssetDTO=new CitizenAssetDTO();
        try {
            citizenAssetDTO=CitizenAssetMapper.getInstance().domainToDto(citizenAsset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return citizenAssetDTO;
    }


    public Optional<CitizenAsset> findByIdEntity(Integer id){
        Specification<CitizenAsset> specification = new Specification<CitizenAsset>() {
            @Override
            public Predicate toPredicate(Root<CitizenAsset> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return citizenAssetDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {

        citizenAssetDao.delete(findByIdEntity(id).get());
    }

}
