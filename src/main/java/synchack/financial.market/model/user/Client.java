package synchack.financial.market.model.user;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users_client", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
@RequiredArgsConstructor
public class Client extends BaseUser {

  @NotNull
  @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
  private OffsetDateTime registered;

  @Column(name = "validated", nullable = false, columnDefinition = "bool default false")
  private boolean validated;

  public Client(@NotBlank @Size(min = 2, max = 128) String username, @Email @NotBlank @Size(max = 128) String email, boolean enabled, @NotBlank @Size(min = 5, max = 32) String password, @NotBlank Role role) {
    super(username, email, enabled, password, role);
  }
}
