package com.gn.app.service.AdministrativeTask.GnProfile;

import com.gn.app.dao.administrativeTask.GnProfile.GnProfileDao;
import com.gn.app.dto.administrativeTask.GnProfile.GnProfileDTO;
import com.gn.app.mappers.administrativeTask.GnProfile.GnProfileMapper;
import com.gn.app.model.administrativeTask.GnProfile.GnProfile;
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


/**
 * Created by hp on 1/7/2019.
 */
@Service
public class GnProfileServiceImpl implements GnProfileService {

    @Autowired
    GnProfileDao gnProfileDao;


    @Override
    public DataTablesOutput<GnProfileDTO> findAllDataTable(DataTablesInput input) {

        DataTablesOutput<GnProfile> output=gnProfileDao.findAll(input);
        DataTablesOutput<GnProfileDTO> dataTablesOutput= null;
        try {
           dataTablesOutput = GnProfileMapper.getInstance().domainToDTODataTablesOutput(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<GnProfileDTO> findAll() {
        List<GnProfileDTO> profiles = null;
        try {
            profiles = GnProfileMapper.getInstance().domainToDTOList(gnProfileDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public GnProfileDTO create(GnProfileDTO gnProfileDTO) {


        if(gnProfileDTO.getId() != null){
            return update(gnProfileDTO);
        }else{
           return save(gnProfileDTO);
        }


    }
    private GnProfileDTO  update(GnProfileDTO gnProfileDTO){
        GnProfile gnProfile=findByIdEntity(gnProfileDTO.getId()).get();
        try {
            GnProfileMapper.getInstance().dtoToDomain(gnProfileDTO,gnProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(gnProfile);
        return gnProfileDTO;
    }
    private GnProfileDTO  save(GnProfileDTO gnProfileDTO){
        GnProfile gnProfile=new GnProfile();
        try {
            GnProfileMapper.getInstance().dtoToDomain(gnProfileDTO,gnProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(gnProfile);
        return gnProfileDTO;
    }

    private void saveOrUpdate(GnProfile gnProfile){
         gnProfileDao.save(gnProfile);
    }
    @Override
    public GnProfileDTO findById(Integer id) {
        GnProfile gnProfile=findByIdEntity(id).get();
        GnProfileDTO gnProfileDTO=new GnProfileDTO();
        try {
            gnProfileDTO=GnProfileMapper.getInstance().domainToDto(gnProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gnProfileDTO;
    }


    public Optional<GnProfile> findByIdEntity(Integer id){
        Specification<GnProfile> specification = new Specification<GnProfile>() {
            @Override
            public Predicate toPredicate(Root<GnProfile> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return gnProfileDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {
        gnProfileDao.delete(findByIdEntity(id).get());
    }


}
