package synchack.financial.market.config.auth;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import synchack.financial.market.model.user.User;
import synchack.financial.market.dto.CredentialsDto;
import synchack.financial.market.service.UserService;

import java.util.Collection;

@Component
public class AuthProviderImpl implements AuthProvider{
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthProviderImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(CredentialsDto credentialsDto) {
        Authentication authentication = getToken(credentialsDto);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }

    private Authentication getToken(CredentialsDto credentialsDto) throws AuthenticationException
    {
        String username = credentialsDto.getUsername();
        String password = credentialsDto.getPassword();

        User baseUser = userService.getUserByUserName(username);

        if(baseUser != null && (baseUser.getUsername().equals(username) || baseUser.getEmail().equals(username))) {
            if(!passwordEncoder.matches(password, baseUser.getPassword())) {
                throw new BadCredentialsException("Wrong password");
            }

            Collection<? extends GrantedAuthority> authorities = baseUser.getAuthorities();
            return new UsernamePasswordAuthenticationToken(baseUser, password, authorities);
        }
        else
            throw new BadCredentialsException("Username not found");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    public boolean supports(Class<?> arg)
    {
        return true;
    }


}