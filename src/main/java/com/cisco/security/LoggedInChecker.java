package com.cisco.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cisco.models.User;

@Component
public class LoggedInChecker {
    public User getLoggedInUser() {
        User user = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            // principal can be "anonymousUser" (String)
            if (principal instanceof CiscoUserDetails) {
                CiscoUserDetails userDetails = (CiscoUserDetails) principal;
                user = userDetails.getUser();
            }
        }

        return user;
    }
}
