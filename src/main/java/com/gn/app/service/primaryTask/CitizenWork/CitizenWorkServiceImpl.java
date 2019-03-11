package com.gn.app.service.primaryTask.CitizenWork;

import com.gn.app.dao.primaryTask.CitizenWork.CitizenWorkDao;
import com.gn.app.dto.administrativeTask.DiaryLog.DiaryLogDTO;
import com.gn.app.dto.primaryTask.CitizenWork.CitizenWorkDTO;
import com.gn.app.mappers.primaryTask.CitizenWork.CitizenWorkMapper;
import com.gn.app.model.primaryTask.CitizenWork.CitizenWork;
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
public class CitizenWorkServiceImpl implements CitizenWorkService {

    @Autowired
    CitizenWorkDao citizenWorkDao;

    @Override
    public DataTablesOutput<CitizenWorkDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<CitizenWork> output = citizenWorkDao.findAll(input);
        DataTablesOutput<CitizenWorkDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = CitizenWorkMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }


    @Override
    public List<CitizenWorkDTO> findAll() {
        List<CitizenWorkDTO> profiles = null;
        try {
            profiles= CitizenWorkMapper.getInstance().domainToDTOList(citizenWorkDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }



    @Override
    public CitizenWorkDTO create(CitizenWorkDTO citizenWorkDTO) {


        if(citizenWorkDTO.getsId() != null){
            return update(citizenWorkDTO);
        }else{
            return save(citizenWorkDTO);
        }
    }

    private CitizenWorkDTO update(CitizenWorkDTO citizenWorkDTO) {
        CitizenWork citizenWork = findByIdEntity(citizenWorkDTO.getsId()).get();
        try {
            CitizenWorkMapper.getInstance().dtoToDomain(citizenWorkDTO, citizenWork);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(citizenWork);
        return citizenWorkDTO;
    }

    private CitizenWorkDTO save(CitizenWorkDTO citizenWorkDTO){
        CitizenWork citizenWork = new CitizenWork();
        try {
            CitizenWorkMapper.getInstance().dtoToDomain(citizenWorkDTO, citizenWork);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(citizenWork);
        return citizenWorkDTO;
    }

    private void saveOrUpdate(CitizenWork citizenWork) {
        citizenWorkDao.save(citizenWork);
    }


    @Override
    public CitizenWorkDTO findById(Integer sid) {
        CitizenWork citizenWork = findByIdEntity(sid).get();
        CitizenWorkDTO citizenWorkDTO = new CitizenWorkDTO();
        try {
            citizenWorkDTO = CitizenWorkMapper.getInstance().domainToDto(citizenWork);
        }catch (Exception e){
            e.printStackTrace();
        }
        return citizenWorkDTO;
    }

    public Optional<CitizenWork> findByIdEntity(Integer sid){
        Specification<CitizenWork> specification = new Specification<CitizenWork>() {
            @Override
            public Predicate toPredicate(Root<CitizenWork> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("sid"), sid);
            }
        };
        return citizenWorkDao.findOne(specification);
    }

    @Override
    public void delete(Integer sid) {
        citizenWorkDao.delete(findByIdEntity(sid).get());

    }
}
