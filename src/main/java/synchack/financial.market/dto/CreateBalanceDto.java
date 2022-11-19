package synchack.financial.market.dto;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateBalanceDto extends BaseDto {

  private Long clientId;

  private String currency;

  private BigDecimal amount;

  public CreateBalanceDto(Long id, Long clientId, String currency, BigDecimal amount) {
    super(id);
    this.clientId = clientId;
    this.currency = currency;
    this.amount = amount;
  }
}
