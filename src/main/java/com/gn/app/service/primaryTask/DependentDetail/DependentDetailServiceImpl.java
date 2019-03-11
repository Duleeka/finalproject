package com.gn.app.service.primaryTask.DependentDetail;

import com.gn.app.dao.primaryTask.DependentDetail.DependentDetailDao;
import com.gn.app.dto.primaryTask.DependentDetail.DependentDetailDTO;
import com.gn.app.mappers.primaryTask.DependentDetail.DependentDetailMapper;
import com.gn.app.model.primaryTask.DependentDetail.DependentDetail;
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
public class DependentDetailServiceImpl implements DependentDetailService {

    @Autowired
    DependentDetailDao dependentDetailDao;

    @Override
    public DataTablesOutput<DependentDetailDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<DependentDetail> output = dependentDetailDao.findAll(input);
        DataTablesOutput<DependentDetailDTO>  dataTablesOutput = null;
        try{
            dataTablesOutput = DependentDetailMapper.getInstance().domainToDTODataTablesOutput (output);

        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }


    @Override
    public List<DependentDetailDTO> findAll() {
        List<DependentDetailDTO> profiles = null;
        try{
            profiles = DependentDetailMapper.getInstance().domainToDTOList(dependentDetailDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }


    @Override
    public DependentDetailDTO create(DependentDetailDTO dependentDetailDTO) {


        if(dependentDetailDTO.getDeId() != null){
            return update(dependentDetailDTO);
        }else{
            return save(dependentDetailDTO);
        }
    }


    private DependentDetailDTO update(DependentDetailDTO dependentDetailDTO){
       DependentDetail dependentDetail= findByEntity(dependentDetailDTO.getDeId()).get();
       try {
           DependentDetailMapper.getInstance().dtoToDomain(dependentDetailDTO,dependentDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(dependentDetail);
        return dependentDetailDTO;
    }
    private DependentDetailDTO  save(DependentDetailDTO dependentDetailDTO){
        DependentDetail dependentDetail=new DependentDetail();
        try {
           DependentDetailMapper.getInstance().dtoToDomain(dependentDetailDTO,dependentDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(dependentDetail);
        return dependentDetailDTO;
    }

    private void saveOrUpdate(DependentDetail dependentDetail){
        dependentDetailDao.save(dependentDetail);
    }

    @Override
    public DependentDetailDTO findById(Integer deid) {
        DependentDetail dependentDetail=findByEntity(deid).get();
        DependentDetailDTO dependentDetailDTO=new DependentDetailDTO();
        try {
            dependentDetailDTO= DependentDetailMapper.getInstance().domainToDto(dependentDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dependentDetailDTO;
    }


    public Optional<DependentDetail> findByEntity(Integer deid) {
        Specification<DependentDetail> specification = new Specification<DependentDetail>() {
            @Override
            public Predicate toPredicate(Root<DependentDetail> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("deid"), deid);
            }
        };
        return dependentDetailDao.findOne(specification);
    }

    @Override
    public void delete(Integer deid) {dependentDetailDao.delete(findByEntity(deid).get());
    }



}
