package com.cisco.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cisco.security.CiscoUserDetails;
import com.cisco.dao.UserDAO;
import com.cisco.models.User;

@Service
public class CiscoUserDetailsService implements UserDetailsService {

	private final UserDAO userDAO;

    @Autowired
    CiscoUserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<String> permissions = userDAO.getPermissions(user.getEmail());
        for (String permission : permissions) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission));
        }

        return new CiscoUserDetails(user, grantedAuthorities);
    }
}
