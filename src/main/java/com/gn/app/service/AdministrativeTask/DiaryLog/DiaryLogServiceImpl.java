package com.gn.app.service.AdministrativeTask.DiaryLog;

import com.gn.app.dao.administrativeTask.DiaryLog.DiaryLogDao;
import com.gn.app.dto.administrativeTask.DiaryLog.DiaryLogDTO;
import com.gn.app.mappers.administrativeTask.DiaryLog.DiaryLogMapper;
import com.gn.app.model.administrativeTask.DiaryLog.DiaryLog;
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
public class DiaryLogServiceImpl implements DiaryLogService {

    @Autowired
    DiaryLogDao diaryLogDao;


    @Override
    public DataTablesOutput<DiaryLogDTO> findAllDataTable(DataTablesInput input) {

        DataTablesOutput<DiaryLog> output=diaryLogDao.findAll(input);
        DataTablesOutput<DiaryLogDTO> dataTablesOutput= null;
        try {
            dataTablesOutput = DiaryLogMapper.getInstance().domainToDTODataTablesOutput(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<DiaryLogDTO> findAll() {
        List<DiaryLogDTO> profiles = null;
        try {
            profiles = DiaryLogMapper.getInstance().domainToDTOList(diaryLogDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public DiaryLogDTO create(DiaryLogDTO diaryLogDTO) {


        if(diaryLogDTO.getId() != null){
            return update(diaryLogDTO);
        }else{
            return save(diaryLogDTO);
        }
    }


    private DiaryLogDTO  update(DiaryLogDTO diaryLogDTO){
        DiaryLog diaryLog=findByIdEntity(diaryLogDTO.getId()).get();
        try {
            DiaryLogMapper.getInstance().dtoToDomain(diaryLogDTO,diaryLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(diaryLog);
        return diaryLogDTO;
    }
    private DiaryLogDTO save(DiaryLogDTO diaryLogDTO){
        DiaryLog diaryLog=new DiaryLog();
        try {
            DiaryLogMapper.getInstance().dtoToDomain(diaryLogDTO,diaryLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(diaryLog);
        return diaryLogDTO;
    }

    private void saveOrUpdate(DiaryLog diaryLog){
        diaryLogDao.save(diaryLog);
    }


    @Override
    public DiaryLogDTO findById(Integer id) {
        DiaryLog diaryLog=findByIdEntity(id).get();
        DiaryLogDTO diaryLogDTO=new DiaryLogDTO();
        try {
            diaryLogDTO=DiaryLogMapper.getInstance().domainToDto(diaryLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diaryLogDTO;
    }


    public Optional<DiaryLog> findByIdEntity(Integer id){
        Specification<DiaryLog> specification = new Specification<DiaryLog>() {
            @Override
            public Predicate toPredicate(Root<DiaryLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return diaryLogDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {

        diaryLogDao.delete(findByIdEntity(id).get());
    }


}
