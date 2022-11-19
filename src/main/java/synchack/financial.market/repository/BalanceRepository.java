package synchack.financial.market.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import synchack.financial.market.model.balance.Balance;

@Repository
@Transactional(readOnly = true)
public interface BalanceRepository extends JpaRepository<Balance, Long> {

  @Query("SELECT b FROM Balance b WHERE b.clientId=?1")
  List<Balance> getAllBalances(Long clientId);

  @Query("SELECT b FROM Balance b WHERE b.clientId=?1 AND b.currency=?2")
  Optional<Balance> getBalanceByClientIdAndCurrency(Long clientId, String currency);

  @Override
  @Transactional
  Balance save(Balance balance);
}
