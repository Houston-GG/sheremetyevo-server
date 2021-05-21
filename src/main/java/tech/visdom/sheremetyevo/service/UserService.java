package tech.visdom.sheremetyevo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tech.visdom.sheremetyevo.dao.UserDao;
import tech.visdom.sheremetyevo.dto.UserDto;
import tech.visdom.sheremetyevo.exception.UserNotFoundException;
import tech.visdom.sheremetyevo.model.User;

@Service
public class UserService {

    private final UserDao userDao;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserDao userDao, ModelMapper modelMapper) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }

    public User getAuthorizedUserEntity() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserEntity(userDetails.getUsername());
    }

    public UserDto getAuthorizedUserDto() {
        return convertToDto(getAuthorizedUserEntity());
    }

    public User findUserEntity(String login) {
        return userDao.findByLogin(login)
                .orElseThrow(() -> new UserNotFoundException("User with LOGIN " + login + " not found in database."));
    }

    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
