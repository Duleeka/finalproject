package com.gn.app.service.settings.DonationRegister;


import com.gn.app.dao.settings.DonationRegister.DonationRegisterDao;
import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import com.gn.app.dto.settings.DonationRegister.DonationRegisterDTO;
import com.gn.app.mappers.citizenProfileTask.DonationDetail.DonationDetailMapper;
import com.gn.app.mappers.settings.DonationRegister.DonationRegisterMapper;
import com.gn.app.model.Settings.DonationRegister.DonationRegister;
import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetail;
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
public class DonationRegisterServiceImpl implements DonationRegisterService {

    @Autowired
    DonationRegisterDao donationRegisterDao;

    @Override
    public DataTablesOutput<DonationRegisterDTO> findAllDataTable (DataTablesInput input) {

        DataTablesOutput<DonationRegister> output= donationRegisterDao.findAll(input);
        DataTablesOutput<DonationRegisterDTO> dataTablesOutput=null;
        try{
            dataTablesOutput = DonationRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<DonationRegisterDTO> findAll() {
        List<DonationRegisterDTO> profiles=null;
        try {
            profiles= DonationRegisterMapper.getInstance().domainToDTOList(donationRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public DonationRegisterDTO create(DonationRegisterDTO donationRegisterDTO) {


        if(donationRegisterDTO.getId() != null){
            return update(donationRegisterDTO);
        }else{
            return save(donationRegisterDTO);
        }


    }
    private DonationRegisterDTO update(DonationRegisterDTO donationRegisterDTO){
        DonationRegister donationRegister = findByIdEntity(donationRegisterDTO.getId()).get();


        try {
            DonationRegisterMapper.getInstance().dtoToDomain(donationRegisterDTO,donationRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(donationRegister);
        return donationRegisterDTO;
    }

    private DonationRegisterDTO  save(DonationRegisterDTO donationRegisterDTO){
        DonationRegister donationRegister=new DonationRegister();
        try {
            DonationRegisterMapper.getInstance().dtoToDomain(donationRegisterDTO,donationRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(donationRegister);
        return donationRegisterDTO;
    }

    private void saveOrUpdate(DonationRegister donationRegister){
        donationRegisterDao.save(donationRegister);
    }

    public Optional<DonationRegister> findByIdEntity(Integer id){
        Specification<DonationRegister> specification = new Specification<DonationRegister>() {
            @Override
            public Predicate toPredicate(Root<DonationRegister> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return donationRegisterDao.findOne(specification);
    }

    @Override
    public DonationRegisterDTO findById(Integer id) {
        DonationRegister donationRegister=findByIdEntity(id).get();
        DonationRegisterDTO donationRegisterDTO=new DonationRegisterDTO();
        try {
            donationRegisterDTO= DonationRegisterMapper.getInstance().domainToDto(donationRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return donationRegisterDTO;
    }
    @Override
    public void delete(Integer id) {
        donationRegisterDao.delete(findByIdEntity(id).get());
    }

}