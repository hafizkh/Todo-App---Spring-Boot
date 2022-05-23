package com.todoitemlist.todoitemlist.Services;

import com.todoitemlist.todoitemlist.Entities.UserEntity;
import com.todoitemlist.todoitemlist.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
//    @Autowired
    private UserRepository _userRepository;
    public UserService(UserRepository userRepository) {
        this._userRepository = userRepository;
    }

    public UserEntity saveUser(UserEntity user) {
        return _userRepository.save(user);
    }

    public List<UserEntity> FindByEmail(String email) {
        return  _userRepository.findByEmail(email);
    }

//    public void UpdateUserPassword(String email, Instant dateModified, String password) {
//        _userRepository.updateUsersEmail(email,dateModified,password);
//    }
}
