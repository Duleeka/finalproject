package com.gn.app.service.certificateIssuingTask.CertificateDetail;


import com.gn.app.dao.certificateIssuingTask.CertificateDetail.CertificateDetailDao;
import com.gn.app.dto.certificateIssuingTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.mappers.certificateIssuingTask.CertificateDetail.CertificateDetailMapper;
import com.gn.app.model.certificateIssuingTask.CertificateDetail.CertificateDetail;
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
public class CertificateDetailServiceImpl implements CertificateDetailService {

    @Autowired
    CertificateDetailDao certificateDetailDao;
    @Override
    public DataTablesOutput<CertificateDetailDTO> findAllDataTable(DataTablesInput input) {

        DataTablesOutput<CertificateDetail> output=certificateDetailDao.findAll(input);
        DataTablesOutput<CertificateDetailDTO> dataTablesOutput=null;
        try {
            dataTablesOutput = CertificateDetailMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;

    }

    @Override
    public List<CertificateDetailDTO> findAll(){
    List<CertificateDetailDTO> profiles = null;
        try {
            profiles = CertificateDetailMapper.getInstance().domainToDTOList(certificateDetailDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }


    @Override
    public CertificateDetailDTO create(CertificateDetailDTO certificateDetailDTO) {
        if (certificateDetailDTO.getId() != null) {
            return update(certificateDetailDTO);
        } else {
            return save(certificateDetailDTO);
        }
    }

        private CertificateDetailDTO update(CertificateDetailDTO certificateDetailDTO) {
           CertificateDetail certificateDetail=findByIdEntity(certificateDetailDTO.getId()).get();
           try {
               CertificateDetailMapper.getInstance().dtoToDomain(certificateDetailDTO,certificateDetail);
           }catch (Exception e){
               e.printStackTrace();
           }
           saveOrUpdate(certificateDetail);
           return certificateDetailDTO;
        }


    private CertificateDetailDTO save(CertificateDetailDTO certificateDetailDTO) {
        CertificateDetail certificateDetail=new CertificateDetail();
        try {
            CertificateDetailMapper.getInstance().dtoToDomain(certificateDetailDTO,certificateDetail);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(certificateDetail);
        return certificateDetailDTO;
        }

    private void saveOrUpdate(CertificateDetail certificateDetail) {
        certificateDetailDao.save(certificateDetail);
    }

    @Override
    public CertificateDetailDTO findById(Integer id) {
        CertificateDetail certificateDetail=findByIdEntity(id).get();
        CertificateDetailDTO certificateDetailDTO=new CertificateDetailDTO();
        try {
            certificateDetailDTO= CertificateDetailMapper.getInstance().domainToDto(certificateDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certificateDetailDTO;
    }

    private Optional<CertificateDetail> findByIdEntity(Integer id) {
        Specification<CertificateDetail> specification= new Specification<CertificateDetail>() {
            @Override
            public Predicate toPredicate(Root<CertificateDetail> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"),id);
            }
        };
        return certificateDetailDao.findOne(specification);
    }


    @Override
    public void delete(Integer id) {
        certificateDetailDao.delete(findByIdEntity(id).get());

    }
}




