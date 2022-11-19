package synchack.financial.market.config.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import synchack.financial.market.dto.CredentialsDto;

public interface AuthProvider extends AuthenticationProvider {

    Authentication authenticate(CredentialsDto credentialsDto);
}
