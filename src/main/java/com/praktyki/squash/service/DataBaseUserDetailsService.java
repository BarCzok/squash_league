package com.praktyki.squash.service;

import com.praktyki.squash.model.Player;
import com.praktyki.squash.repository.PlayersRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataBaseUserDetailsService implements UserDetailsService {

    @Resource
    PlayersRepository playersRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playersRepository.findById(112221).get();

        if(player != null) {
            return User.withDefaultPasswordEncoder()
                        .username(player.getName())
                        .password("admin")
                        .roles("USER")
                        .build();
        }

        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//
//        //check if user exists
//        		UserDetails admin =
//				User.withDefaultPasswordEncoder()
//						.username("admin")
//						.password("admin")
//						.roles("USER", "ADMIN")
//						.build();
//
//                return admin;
//    }
}

