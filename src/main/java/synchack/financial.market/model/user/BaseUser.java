package synchack.financial.market.model.user;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import synchack.financial.market.model.BaseEntity;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseUser extends BaseEntity {

  @Column(name = "username", nullable = false)
  @NotBlank
  @Size(min = 2, max = 128)
  private String username;

  @Column(name = "email", nullable = false, unique = true)
  @Email
  @NotBlank
  @Size(max = 128)
  private String email;

  @Column(name = "password", nullable = false)
  @NotBlank
  @Size(min = 5, max = 32)
  private String password;
}
