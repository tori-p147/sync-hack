package synchack.financial.market.model.balance;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import synchack.financial.market.model.BaseMonetaryEntity;

@Getter
@Setter
@Entity
@Table(name = "balance", uniqueConstraints = {@UniqueConstraint(columnNames = {"client_id", "currency"},
    name = "user_balance_currency_unique")})
@RequiredArgsConstructor
public class Balance extends BaseMonetaryEntity {

  @Column(name = "locked_amount")
  private BigDecimal lockedAmount;
}
