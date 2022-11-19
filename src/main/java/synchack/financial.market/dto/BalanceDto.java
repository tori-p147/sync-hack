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
public class BalanceDto extends BaseDto {

  private Long clientId;

  private String currency;

  private BigDecimal amount;

  private BigDecimal lockedAmount;

  public BalanceDto(Long id, Long clientId, String currency, BigDecimal amount,
    BigDecimal lockedAmount) {
    super(id);
    this.clientId = clientId;
    this.currency = currency;
    this.amount = amount;
    this.lockedAmount = lockedAmount;
  }
}
