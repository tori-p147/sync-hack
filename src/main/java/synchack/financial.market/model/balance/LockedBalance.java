package synchack.financial.market.model.balance;

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
@Table(name = "locked_balance", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "client_id"},
  name = "user_locked_balance_unique")})
@RequiredArgsConstructor
public class LockedBalance extends BaseMonetaryEntity {
}
