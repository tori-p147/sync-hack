package synchack.financial.market.model.user;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import synchack.financial.market.model.BaseEntity;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@ToString
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseUser extends BaseEntity implements UserDetails {

  @Column(name = "username", nullable = false)
  @NotBlank
  @Size(min = 2, max = 128)
  private String username;

  @Column(name = "email", nullable = false, unique = true)
  @Email
  @NotBlank
  @Size(max = 128)
  private String email;

  @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
  private boolean enabled;

  @Column(name = "password", nullable = false)
  @NotBlank
  @Size(min = 5, max = 32)
  private String password;

  @Column(name = "role", nullable = false)
  @NotBlank
  private Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(role);
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
