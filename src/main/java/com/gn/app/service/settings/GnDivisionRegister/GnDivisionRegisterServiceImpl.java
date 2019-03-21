package com.gn.app.service.settings.GnDivisionRegister;

import com.gn.app.dao.settings.GnDivisionRegister.GnDivisionRegisterDao;
import com.gn.app.dto.settings.GnDivisionRegister.GnDivisionRegisterDTO;
import com.gn.app.mappers.settings.GnDivisionRegister.GnDivisionRegisterMapper;
import com.gn.app.model.Settings.GnDivisionRegister.GnDivisionRegister;
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
public class GnDivisionRegisterServiceImpl implements GnDivisionRegisterService {

    @Autowired
    GnDivisionRegisterDao gnDivisionRegisterDao;

    @Override
    public DataTablesOutput<GnDivisionRegisterDTO> findAllDataTable(DataTablesInput input) {

        DataTablesOutput<GnDivisionRegister> output=gnDivisionRegisterDao.findAll(input);
        DataTablesOutput<GnDivisionRegisterDTO> dataTablesOutput= null;
        try {
            dataTablesOutput = GnDivisionRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesOutput;
    }
    @Override
    public List<GnDivisionRegisterDTO> findAll() {
        List<GnDivisionRegisterDTO> profiles = null;
        try {
            profiles = GnDivisionRegisterMapper.getInstance().domainToDTOList(gnDivisionRegisterDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profiles;
    }
    @Override
    public GnDivisionRegisterDTO create(GnDivisionRegisterDTO gnDivisionRegisterDTO) {


        if(gnDivisionRegisterDTO.getId() != null){
            return update(gnDivisionRegisterDTO);
        }else{
            return save(gnDivisionRegisterDTO);
        }
    }



    private GnDivisionRegisterDTO update(GnDivisionRegisterDTO gnDivisionRegisterDTO) {
        GnDivisionRegister gnDivisionRegister=findByIdEntity(gnDivisionRegisterDTO.getId()).get();
        try {
            GnDivisionRegisterMapper.getInstance().dtoToDomain(gnDivisionRegisterDTO,gnDivisionRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(gnDivisionRegister);
        return gnDivisionRegisterDTO;
    }
    private GnDivisionRegisterDTO save(GnDivisionRegisterDTO gnDivisionRegisterDTO) {
        GnDivisionRegister gnDivisionRegister=new GnDivisionRegister();
        try {
            GnDivisionRegisterMapper.getInstance().dtoToDomain(gnDivisionRegisterDTO,gnDivisionRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(gnDivisionRegister);
        return gnDivisionRegisterDTO;
    }

    private void saveOrUpdate(GnDivisionRegister gnDivisionRegister) {
        gnDivisionRegisterDao.save(gnDivisionRegister);
    }

    public GnDivisionRegisterDTO findById(Integer id) {
        GnDivisionRegister gnDivisionRegister=findByIdEntity(id).get();
        GnDivisionRegisterDTO gnDivisionRegisterDTO=new GnDivisionRegisterDTO();
        try {
            gnDivisionRegisterDTO=GnDivisionRegisterMapper.getInstance().domainToDto(gnDivisionRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gnDivisionRegisterDTO;
    }
    public Optional<GnDivisionRegister> findByIdEntity(Integer id){
        Specification<GnDivisionRegister> specification = new Specification<GnDivisionRegister>() {
            @Override
            public Predicate toPredicate(Root<GnDivisionRegister> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return gnDivisionRegisterDao.findOne(specification);
    }
    @Override
    public void delete(Integer id) {

        gnDivisionRegisterDao.delete(findByIdEntity(id).get());
    }

}

