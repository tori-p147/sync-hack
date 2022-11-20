package synchack.financial.market.model.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import synchack.financial.market.model.BaseMonetaryEntity;

import javax.persistence.*;

@ToString
@Getter
@Table(name = "USER_ROLE")
@Entity
@RequiredArgsConstructor
public class Role extends BaseMonetaryEntity implements GrantedAuthority {

    @Column(name = "username", nullable = false)
    private String role;

    public Role(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority()
    {
        return role;
    }
}