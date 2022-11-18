package synchack.financial.market.model.user;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
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

  @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
  private boolean enabled;
}
