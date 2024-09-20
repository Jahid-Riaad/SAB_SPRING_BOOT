package com.sab.user.security;

import com.sab.user.entity.Authority;
import com.sab.user.entity.UserPrincipal;
import com.sab.user.entity.UserProfile;
import com.sab.user.repository.AuthorityRepository;
import com.sab.user.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class SabUserDetailsService implements UserDetailsService {

    private final UserProfileRepository userProfileRepository;

    private final AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile userProfile = userProfileRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Authority authorities = authorityRepository.findById(userProfile.getAuthority().getId())
                .orElseThrow(() -> new UsernameNotFoundException("Authority not found"));

        userProfile.setAuthority(authorities);

        return new UserPrincipal(userProfile);

        //return new User(userProfile.getUsername(), userProfile.getPassword(), userProfile.getEnabled(), true, true, true, authorities);

    }
}

