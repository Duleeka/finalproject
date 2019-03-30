package com.gn.app.service.citizenProfileTask.DonationDetail;


import com.gn.app.dao.citizenProfileTask.CitizenDetail.CitizenDetailDao;
import com.gn.app.dao.citizenProfileTask.DonationDetail.DonationDetailDao;
import com.gn.app.dao.settings.DonationRegister.DonationRegisterDao;
import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDonationTypeDTO;
import com.gn.app.dto.primaryTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.dto.settings.DonationRegister.DonationRegisterDTO;
import com.gn.app.mappers.citizenProfileTask.DonationDetail.DonationDetailMapper;
import com.gn.app.model.Settings.DonationRegister.DonationRegister;
import com.gn.app.model.Settings.NationalityRegister.NationalityRegister;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;
import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetail;
import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetailsDonationType;
import com.gn.app.model.primaryTask.CertificateDetail.CertificateDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class DonationDetailServiceImpl implements DonationDetailService {

    @Autowired
    DonationDetailDao donationDetailDao;

    @Autowired
    DonationRegisterDao donationRegisterDao;

    @Autowired
    CitizenDetailDao citizenDetailDao;

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
 /*create object for DonationDetailDTO class*/
        setCommonData(donationDetail, donationDetailDTO);
        saveOrUpdate(donationDetail);
        return donationDetailDTO;
    }

    private void saveOrUpdate(DonationDetail donationDetail){
        donationDetailDao.save(donationDetail);
    }


    private void setCommonData(DonationDetail donationDetail, DonationDetailDTO donationDetailDTO){
        setDonationRegister(donationDetail, donationDetailDTO);
        setCitizen(donationDetail,donationDetailDTO);
    }
//associate citizen table with donation detail

    private void setCitizen(DonationDetail donationDetail, DonationDetailDTO donationDetailDTO){

        if(donationDetailDTO != null && donationDetailDTO.getCitizenId()!=null) {

            donationDetail.setCitizenDetail(citizenDetailDao.findOne(findCitizenSpecification(donationDetailDTO.getCitizenId())).get());
        }}


    public Specification<CitizenDetail> findCitizenSpecification(Integer id){
        Specification<CitizenDetail> specification = new Specification<CitizenDetail>() {
            @Override
            public Predicate toPredicate(Root<CitizenDetail> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return specification;
    }




//    List Relationship to multiple donation type for one citizen

    private void setDonationRegister(DonationDetail donationDetail, DonationDetailDTO donationDetailDTO) {
        Set<DonationDetailsDonationType> donationDetailsDonationTypes = new HashSet<>();
        DonationDetailsDonationType donationDetailsDonationType;

        for(DonationDetailDonationTypeDTO donationRegisterDTO:donationDetailDTO.getDonationRegisterDTOS()){
            if(donationDetailDTO!= null && donationDetailDTO.getId()!=null && donationDetailDTO.getDonationRegisterDTOS() != null ){
                Optional<DonationDetailsDonationType>
                        optional=donationDetail.getDonationDetailsDonationTypes().stream().filter((x)-> x.getId().equals(donationRegisterDTO.getId())).findAny();

                if(optional.isPresent()){
                    donationDetailsDonationType=optional.get();
                }else{
                    donationDetailsDonationType=new DonationDetailsDonationType();
                }
            }else {
                donationDetailsDonationType=new DonationDetailsDonationType();
            }

            donationDetailsDonationType.setDonationRegister(donationRegisterDao.findOne(findDonationRegisterSpecification(donationRegisterDTO.getDonationRegisterId())).get());
            donationDetailsDonationType.setDonationDetail(donationDetail);
            donationDetailsDonationType.setId(donationRegisterDTO.getId());
            donationDetailsDonationType.setVersion(donationRegisterDTO.getVersion());
            donationDetailsDonationTypes.add(donationDetailsDonationType);
        }
        donationDetail.setDonationDetailsDonationTypes(donationDetailsDonationTypes);
    }

    private Specification<DonationRegister> findDonationRegisterSpecification(Integer id) {
        Specification<DonationRegister> specification = new Specification<DonationRegister>() {
            @Override
            public Predicate toPredicate(Root<DonationRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);

            }
        };
        return specification;
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
    public void delete(Integer id) {
        donationDetailDao.delete(findByIdEntity(id).get());
    }

    }

