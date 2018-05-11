package com.flocondria.fridge.auth.security;

import com.flocondria.fridge.auth.exception.ResourceNotFoundException;
import com.flocondria.fridge.auth.model.User;
import com.flocondria.fridge.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                                  .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
        );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(UUID uuid) {
        Optional optional = userRepository.findById(uuid);

        if(optional.isPresent()){
            User user = (User) optional.get();
            return UserPrincipal.create(user);
        }
        throw new ResourceNotFoundException("User", "id", uuid);

    }
}