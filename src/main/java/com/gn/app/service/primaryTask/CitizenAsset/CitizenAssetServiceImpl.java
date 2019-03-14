package com.gn.app.service.primaryTask.CitizenAsset;

import com.gn.app.dao.primaryTask.CitizenAsset.CitizenAssetDao;
import com.gn.app.dto.primaryTask.CitizenAsset.CitizenAssetDTO;
import com.gn.app.mappers.primaryTask.CitizenAsset.CitizenAssetMapper;
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
        saveOrUpdate(citizenAsset);
        return citizenAssetDTO;
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
