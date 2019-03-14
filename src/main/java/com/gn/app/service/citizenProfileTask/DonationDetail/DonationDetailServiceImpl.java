package com.gn.app.service.citizenProfileTask.DonationDetail;


import com.gn.app.dao.citizenProfileTask.DonationDetail.DonationDetailDao;
import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import com.gn.app.mappers.citizenProfileTask.DonationDetail.DonationDetailMapper;
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
public class DonationDetailServiceImpl implements DonationDetailService {

    @Autowired
    DonationDetailDao donationDetailDao;

    @Override
    public DataTablesOutput<DonationDetailDTO> findAllDataTable (DataTablesInput input) {

        DataTablesOutput<DonationDetail> output= donationDetailDao.findAll(input);
        DataTablesOutput<DonationDetailDTO> dataTablesOutput=null;
        try{
            dataTablesOutput = DonationDetailMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<DonationDetailDTO> findAll() {
        List<DonationDetailDTO> profiles=null;
       try {
           profiles=DonationDetailMapper.getInstance().domainToDTOList(donationDetailDao.findAll());
       }catch (Exception e){
           e.printStackTrace();
       }
        return profiles;
    }

    @Override
    public DonationDetailDTO create(DonationDetailDTO donationDetailDTO) {


        if(donationDetailDTO.getId() != null){
            return update(donationDetailDTO);
        }else{
            return save(donationDetailDTO);
        }


    }
    private DonationDetailDTO update(DonationDetailDTO donationDetailDTO){
        DonationDetail donationDetail= findByIdEntity(donationDetailDTO.getId()).get();


        try {
            DonationDetailMapper.getInstance().dtoToDomain(donationDetailDTO,donationDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(donationDetail);
        return donationDetailDTO;
    }

    private DonationDetailDTO  save(DonationDetailDTO donationDetailDTO){
        DonationDetail donationDetail=new DonationDetail();
        try {
            DonationDetailMapper.getInstance().dtoToDomain(donationDetailDTO,donationDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(donationDetail);
        return donationDetailDTO;
    }

    private void saveOrUpdate(DonationDetail donationDetail){
        donationDetailDao.save(donationDetail);
    }

    public Optional<DonationDetail> findByIdEntity(Integer id){
        Specification<DonationDetail> specification = new Specification<DonationDetail>() {
            @Override
            public Predicate toPredicate(Root<DonationDetail> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return donationDetailDao.findOne(specification);
    }

    @Override
    public DonationDetailDTO findById(Integer id) {
        DonationDetail donationDetail=findByIdEntity(id).get();
        DonationDetailDTO donationDetailDTO=new DonationDetailDTO();
        try {
            donationDetailDTO= DonationDetailMapper.getInstance().domainToDto(donationDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return donationDetailDTO;
    }
    @Override
    public void delete(Integer id) {
        donationDetailDao.delete(findByIdEntity(id).get());
    }

    }

