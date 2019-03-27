package com.gn.app.service.settings.WallDetailRegister;

import com.gn.app.dao.settings.LandDetailRegister.LandDetailRegisterDao;
import com.gn.app.dao.settings.WallDetailRegister.WallDetailRegisterDao;
import com.gn.app.dto.settings.LandDetailRegister.LandDetailRegisterDTO;
import com.gn.app.dto.settings.WallDetailRegister.WallDetailRegisterDTO;
import com.gn.app.mappers.settings.LandDetailRegister.LandDetailRegisterMapper;
import com.gn.app.mappers.settings.WallDetailRegister.WallDetailRegisterMapper;
import com.gn.app.model.Settings.LandDetailRegister.LandDetailRegister;
import com.gn.app.model.Settings.WallDetailRegister.WallDetailRegister;
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
public class WallDetailRegisterServiceImpl implements WallDetailRegisterService {

    @Autowired
    WallDetailRegisterDao wallDetailRegisterDao;

    @Override
    public DataTablesOutput<WallDetailRegisterDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<WallDetailRegister> output = wallDetailRegisterDao.findAll(input);
        DataTablesOutput<WallDetailRegisterDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = WallDetailRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<WallDetailRegisterDTO> findAll() {
        List<WallDetailRegisterDTO> profiles = null;
        try {
            profiles= WallDetailRegisterMapper.getInstance().domainToDTOList(wallDetailRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public WallDetailRegisterDTO create(WallDetailRegisterDTO wallDetailRegisterDTO) {


        if(wallDetailRegisterDTO.getId() != null){
            return update(wallDetailRegisterDTO);
        }else{
            return save(wallDetailRegisterDTO);
        }
    }
    private WallDetailRegisterDTO update(WallDetailRegisterDTO wallDetailRegisterDTO) {
        WallDetailRegister wallDetailRegister = findByIdEntity(wallDetailRegisterDTO.getId()).get();
        try {
            WallDetailRegisterMapper.getInstance().dtoToDomain(wallDetailRegisterDTO, wallDetailRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(wallDetailRegister);
        return wallDetailRegisterDTO;
    }

    private WallDetailRegisterDTO save(WallDetailRegisterDTO wallDetailRegisterDTO){
        WallDetailRegister wallDetailRegister = new WallDetailRegister();
        try {
            WallDetailRegisterMapper.getInstance().dtoToDomain(wallDetailRegisterDTO, wallDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(wallDetailRegister);
        return wallDetailRegisterDTO;
    }

    private void saveOrUpdate(WallDetailRegister wallDetailRegister)
    {
        wallDetailRegisterDao.save(wallDetailRegister);
    }

    @Override
    public WallDetailRegisterDTO findById(Integer id) {
        WallDetailRegister wallDetailRegister = findByIdEntity(id).get();
        WallDetailRegisterDTO wallDetailRegisterDTO = new WallDetailRegisterDTO();
        try {
            wallDetailRegisterDTO = WallDetailRegisterMapper.getInstance().domainToDto(wallDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        return wallDetailRegisterDTO;
    }

    public Optional<WallDetailRegister> findByIdEntity(Integer id){
        Specification<WallDetailRegister> specification = new Specification<WallDetailRegister>() {
            @Override
            public Predicate toPredicate(Root<WallDetailRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return wallDetailRegisterDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {wallDetailRegisterDao.delete(findByIdEntity(id).get());
    }
}
