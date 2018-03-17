package com.atlyakov.vshop.service.util;

import com.atlyakov.vshop.entity.enums.Access;
import com.atlyakov.vshop.entity.enums.Role;
import com.atlyakov.vshop.entity.User;
import com.atlyakov.vshop.service.model.UserDTO;

public class UserConverter {

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());
        user.setMail(userDTO.getMail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setRole(Role.ROLE_USER);
        user.setAccess(Access.ACTIVE);
        return user;
    }

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setMail(user.getMail());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setMiddleName(user.getMiddleName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole());
        userDTO.setAccess(user.getAccess());
        return userDTO;
    }


}
