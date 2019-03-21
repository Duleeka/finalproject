package com.gn.app.service.settings.CertificateDetailRegister;

import com.gn.app.dao.settings.CertificateDetailRegister.CertificateDetailRegisterDao;
import com.gn.app.dto.primaryTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.dto.settings.CertificateDetailRegister.CertificateDetailRegisterDTO;
import com.gn.app.mappers.primaryTask.CertificateDetail.CertificateDetailMapper;
import com.gn.app.mappers.settings.CertificateDetailRegister.CertificateDetailRegisterMapper;
import com.gn.app.model.Settings.CertificateDetailRegister.CertificateDetailRegister;
import com.gn.app.model.primaryTask.CertificateDetail.CertificateDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateDetailRegisterServiceImpl implements CertificateDetailRegisterService {

    @Autowired
    CertificateDetailRegisterDao certificateDetailRegisterDao;

    @Override
    public DataTablesOutput<CertificateDetailRegisterDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<CertificateDetailRegister> output=certificateDetailRegisterDao.findAll(input);
        DataTablesOutput<CertificateDetailRegisterDTO> dataTablesOutput=null;
        try {
            dataTablesOutput = CertificateDetailRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<CertificateDetailRegisterDTO> findAll() {
        List<CertificateDetailRegisterDTO> profiles = null;
        try {
            profiles = CertificateDetailRegisterMapper.getInstance().domainToDTOList(certificateDetailRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public CertificateDetailRegisterDTO create(CertificateDetailRegisterDTO certificateDetailRegisterDTO) {

        if (certificateDetailRegisterDTO.getId() != null) {
            return update(certificateDetailRegisterDTO);
        } else {
            return save(certificateDetailRegisterDTO);
        }
    }


    private CertificateDetailRegisterDTO update(CertificateDetailRegisterDTO certificateDetailRegisterDTO) {
        CertificateDetailRegister certificateDetailRegister=findByIdEntity(certificateDetailRegisterDTO.getId()).get();
        try {
            CertificateDetailRegisterMapper.getInstance().dtoToDomain(certificateDetailRegisterDTO,certificateDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(certificateDetailRegister);
        return certificateDetailRegisterDTO;
    }


    private CertificateDetailRegisterDTO save(CertificateDetailRegisterDTO certificateDetailRegisterDTO) {
        CertificateDetailRegister certificateDetailRegister=new CertificateDetailRegister();
        try {
            CertificateDetailRegisterMapper.getInstance().dtoToDomain(certificateDetailRegisterDTO,certificateDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(certificateDetailRegister);
        return certificateDetailRegisterDTO;
    }

    private void saveOrUpdate(CertificateDetailRegister certificateDetailRegister) {
        certificateDetailRegisterDao.save(certificateDetailRegister);
    }



    @Override
    public CertificateDetailRegisterDTO findById(Integer id) {
        CertificateDetailRegister certificateDetailRegister=findByIdEntity(id).get();
        CertificateDetailRegisterDTO certificateDetailRegisterDTO=new CertificateDetailRegisterDTO();
        try {
            certificateDetailRegisterDTO= CertificateDetailRegisterMapper.getInstance().domainToDto(certificateDetailRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certificateDetailRegisterDTO;
    }

    private Optional<CertificateDetailRegister> findByIdEntity(Integer id) {
        Specification<CertificateDetailRegister> specification= new Specification<CertificateDetailRegister>() {
            @Override
            public Predicate toPredicate(Root<CertificateDetailRegister> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"),id);
            }
        };
        return certificateDetailRegisterDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {
        certificateDetailRegisterDao.delete(findByIdEntity(id).get());

    }
}
