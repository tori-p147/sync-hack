package synchack.financial.market.model.user;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
@Table(name = "users_admin", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_admin_email_idx")})
@RequiredArgsConstructor
public class Admin extends BaseUser {

}
