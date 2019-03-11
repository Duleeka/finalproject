package com.gn.app.service.primaryTask.CitizenDonation;

import com.gn.app.dao.primaryTask.CitizenDonation.CitizenDonationDao;
import com.gn.app.dto.primaryTask.CitizenDonation.CitizenDonationDTO;
import com.gn.app.mappers.primaryTask.CitizenDonation.CitizenDonationMapper;
import com.gn.app.model.primaryTask.CitizenDonation.CitizenDonation;
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
public class CitizenDonationServiceImpl implements CitizenDonationService {

    @Autowired
    CitizenDonationDao citizenDonationDao;

    @Override
    public DataTablesOutput<CitizenDonationDTO> findAllDataTable(DataTablesInput input) {

        DataTablesOutput<CitizenDonation> output=citizenDonationDao.findAll(input);
        DataTablesOutput<CitizenDonationDTO> dataTablesOutput= null;
        try {
            dataTablesOutput = CitizenDonationMapper.getInstance().domainToDTODataTablesOutput(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<CitizenDonationDTO> findAll() {
       List<CitizenDonationDTO> profiles =  null;

       try {
           profiles = CitizenDonationMapper.getInstance().domainToDTOList(citizenDonationDao.findAll());
       }catch (Exception e){
           e.printStackTrace();
       }
        return profiles;
    }

    @Override
    public CitizenDonationDTO create(CitizenDonationDTO citizenDonationDTO) {
        if (citizenDonationDTO.getId() != null) {
            return update(citizenDonationDTO);
        } else {
            return save(citizenDonationDTO);
        }
    }

        private CitizenDonationDTO update(CitizenDonationDTO citizenDonationDTO){
            CitizenDonation citizenDonation = findByIdEntity(citizenDonationDTO.getId()).get();
            try {
                CitizenDonationMapper.getInstance().dtoToDomain(citizenDonationDTO,citizenDonation);
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveOrUpdate(citizenDonation);
            return citizenDonationDTO;
        }
        private CitizenDonationDTO save(CitizenDonationDTO citizenDonationDTO){
           CitizenDonation citizenDonation=new CitizenDonation();
            try {
                CitizenDonationMapper.getInstance().dtoToDomain(citizenDonationDTO, citizenDonation);
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveOrUpdate(citizenDonation);
            return citizenDonationDTO;
        }

        private void saveOrUpdate(CitizenDonation citizenDonation){
            citizenDonationDao.save(citizenDonation);
        }


        @Override
        public CitizenDonationDTO findById(Integer id) {
            CitizenDonation citizenDonation=findByIdEntity(id).get();
            CitizenDonationDTO citizenDonationDTO=new CitizenDonationDTO();
            try {
                citizenDonationDTO=CitizenDonationMapper.getInstance().domainToDto(citizenDonation);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return citizenDonationDTO;
        }


        public Optional<CitizenDonation> findByIdEntity(Integer id){
            Specification<CitizenDonation> specification = new Specification<CitizenDonation>() {
                @Override
                public Predicate toPredicate(Root<CitizenDonation> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                    return cb.equal(root.get("id"), id);
                }
            };
            return citizenDonationDao.findOne(specification);
        }

        @Override
        public void delete(Integer id) {
            citizenDonationDao.delete(findByIdEntity(id).get());
        }


    }
