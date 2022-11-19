package synchack.financial.market.model.user;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
@ToString
public enum Role implements GrantedAuthority
{
    USER,
    ADMIN;

    @Override
    public String getAuthority()
    {
        return name();
    }
}