// Package declaration for the auditing component in a library security system.
package com.library.security.auditing;

// Importing necessary classes and interfaces.
import com.library.security.user.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

// Class that implements the AuditorAware interface to determine the current auditor based on the user's authentication.
public class ApplicationAuditAware implements AuditorAware<Integer> {
    // Method to fetch the current auditor's identifier.
    @SuppressWarnings("null")
    @Override
    public Optional<Integer> getCurrentAuditor() {
        // Retrieve the current Authentication object from the security context.
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        // Check if authentication is null, not authenticated, or is an instance of AnonymousAuthenticationToken.
        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken
        ) {
            // Return an empty Optional if any conditions are true, indicating no authenticated user.
            return Optional.empty();
        }

        // Cast the Authentication's principal to a User object.
        User userPrincipal = (User) authentication.getPrincipal();
        // Return the user's ID wrapped in an Optional, if it's not null.
        return Optional.ofNullable(userPrincipal.getId());
    }
}
