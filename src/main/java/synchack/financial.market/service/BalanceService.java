package synchack.financial.market.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import synchack.financial.market.error.NotFoundException;
import synchack.financial.market.model.balance.Balance;
import synchack.financial.market.repository.BalanceRepository;

@Service
@RequiredArgsConstructor
public class BalanceService {

  @Autowired
  private final BalanceRepository balanceRepository;

  public Balance getBalance(Long clientId, String currency) {
    return balanceRepository.getBalanceByClientIdAndCurrency(clientId, currency)
      .orElseThrow(() -> new NotFoundException("User`s " + clientId + "balance not found"));
  }

  public List<Balance> getAllBalances(Long clientId) {
    return balanceRepository.getAllBalances(clientId);
  }

  public Balance create(Balance balance, Long clientId) {
    Assert.notNull(balance, "Balance must not be null");
    balance.setClientId(clientId);
    return balanceRepository.save(balance);
  }

  public void update(Balance balance, Long clientId) {
    Assert.notNull(balance, "Balance must not be null");
    balance.setClientId(clientId);
    balanceRepository.save(balance);
  }
}
