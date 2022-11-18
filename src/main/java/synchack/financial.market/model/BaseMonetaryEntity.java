package synchack.financial.market.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseMonetaryEntity extends BaseEntity {

  @Column(name = "client_id", nullable = false)
  private Long clientId;

  @Column(name = "currency", nullable = false)
  @NotBlank
  @Size(max = 3)
  private String currency;

  @Column(name = "amount")
  private BigDecimal amount;
}
