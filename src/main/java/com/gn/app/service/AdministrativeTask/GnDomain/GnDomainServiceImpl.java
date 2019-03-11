package com.gn.app.service.AdministrativeTask.GnDomain;

import com.gn.app.dao.administrativeTask.GnDomain.GnDomainDao;
import com.gn.app.dto.administrativeTask.DiaryLog.DiaryLogDTO;
import com.gn.app.dto.administrativeTask.GnDomain.GnDomainDTO;
import com.gn.app.mappers.administrativeTask.DiaryLog.DiaryLogMapper;
import com.gn.app.mappers.administrativeTask.GnDomain.GnDomainMapper;
import com.gn.app.model.administrativeTask.DiaryLog.DiaryLog;
import com.gn.app.model.administrativeTask.GnDomain.GnDomain;
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
public class GnDomainServiceImpl  implements GnDomainService {

    @Autowired
    GnDomainDao gnDomainDao;

    @Override
    public DataTablesOutput<GnDomainDTO> findAllDataTable(DataTablesInput input) {

        DataTablesOutput<GnDomain> output=gnDomainDao.findAll(input);
        DataTablesOutput<GnDomainDTO> dataTablesOutput= null;
        try {
            dataTablesOutput = GnDomainMapper.getInstance().domainToDTODataTablesOutput(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<GnDomainDTO> findAll() {
            List<GnDomainDTO> profiles = null;
            try {
                profiles = GnDomainMapper.getInstance().domainToDTOList(gnDomainDao.findAll());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return profiles;
        }

    @Override
    public GnDomainDTO create(GnDomainDTO gnDomainDTO) {
        if(gnDomainDTO.getId() != null){
            return update(gnDomainDTO);
        }else{
            return save(gnDomainDTO);
        }
    }

    private GnDomainDTO  update(GnDomainDTO gnDomainDTO){
        GnDomain gnDomain=findByIdEntity(gnDomainDTO.getId()).get();
        try {
            GnDomainMapper.getInstance().dtoToDomain(gnDomainDTO,gnDomain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(gnDomain);
        return gnDomainDTO;
    }

    private GnDomainDTO save(GnDomainDTO gnDomainDTO){
        GnDomain gnDomain=new GnDomain();
        try {
            GnDomainMapper.getInstance().dtoToDomain(gnDomainDTO, gnDomain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(gnDomain);
        return gnDomainDTO;
    }


    private void saveOrUpdate(GnDomain  gnDomain){
        gnDomainDao.save(gnDomain);
    }
    @Override
    public GnDomainDTO findById(Integer id) {
       GnDomain gnDomain=findByIdEntity(id).get();
        GnDomainDTO gnDomainDTO=new GnDomainDTO();
        try {
           gnDomainDTO=GnDomainMapper.getInstance().domainToDto(gnDomain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gnDomainDTO;
    }



    public Optional<GnDomain> findByIdEntity(Integer id){
        Specification<GnDomain> specification = new Specification<GnDomain>() {
            @Override
            public Predicate toPredicate(Root<GnDomain> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return gnDomainDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {
        gnDomainDao.delete(findByIdEntity(id).get());
    }


}