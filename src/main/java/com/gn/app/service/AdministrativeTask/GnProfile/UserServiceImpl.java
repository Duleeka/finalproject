package com.gn.app.service.AdministrativeTask.GnProfile;

import com.gn.app.dao.settings.UserDao;
import com.gn.app.dto.administrativeTask.GnProfile.GnProfileDTO;
import com.gn.app.dto.settings.UserDTO;
import com.gn.app.mappers.UserMapper;
import com.gn.app.mappers.administrativeTask.GnProfile.GnProfileMapper;
import com.gn.app.model.Settings.User;
import com.gn.app.model.administrativeTask.GnProfile.GnProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by hp on 2/28/2019.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public DataTablesOutput<UserDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<User> output=userRepository.findAll(input);
        DataTablesOutput<UserDTO> dataTablesOutput= null;
        try {
            dataTablesOutput = UserMapper.getInstance().domainToDTODataTablesOutput(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }


    @Override
    public UserDTO create(UserDTO dto) {

        if(dto.getId() != null){
            return update(dto);
        }else{
            return save(dto);
        }

    }


    private UserDTO  update(UserDTO dto){
        User user=findByIdEntity(dto.getId()).get();
        try {
            UserMapper.getInstance().dtoToDomain(dto,user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(user);
        return dto;
    }
    private UserDTO  save(UserDTO dto){
        User user=new User();
        try {
            UserMapper.getInstance().dtoToDomain(dto,user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(user);
        return dto;
    }

    private void saveOrUpdate(User user){
        encodePassword(user);
        userRepository.save(user);
    }

    public UserDTO findById(Integer id) {
        User user=findByIdEntity(id).get();
        UserDTO dto=new UserDTO();
        try {
            dto=UserMapper.getInstance().domainToDto(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    private void encodePassword(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }


    public Optional<User> findByIdEntity(Integer id){
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return userRepository.findOne(specification);
    }

    @Override
    public void delete(Integer id) {

            userRepository.delete(findByIdEntity(id).get());
    }
}