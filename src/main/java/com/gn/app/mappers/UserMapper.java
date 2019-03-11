package com.gn.app.mappers;

import com.gn.app.dto.settings.UserDTO;
import com.gn.app.mappers.administrativeTask.GnProfile.GnProfileMapper;
import com.gn.app.model.Settings.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 * Created by hp on 2/28/2019.
 */
public class UserMapper extends GenericMapper<User,UserDTO> {

    private static UserMapper instance = null;

    private UserMapper(){
    }

    public static UserMapper getInstance() {
        if (instance == null) {
            instance = new UserMapper();
        }
        return instance;
    }

    @Override
    public UserDTO domainToDto(User user) throws Exception {
        UserDTO dto =new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
       // dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setVersion(user.getVersion());
        return dto;
    }

    @Override
    public UserDTO domainToDtoForDataTable(User user) throws Exception {
        UserDTO dto =new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }

    @Override
    public void dtoToDomain(UserDTO dto, User user) throws Exception {
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setIsDeleted(false);
        user.setRole(dto.getRole());
        user.setVersion(dto.getVersion());
    }
}
