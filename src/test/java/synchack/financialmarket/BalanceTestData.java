package synchack.financialmarket;

import synchack.financial.market.model.balance.Balance;

public class BalanceTestData {
  public static final MatcherFactory.Matcher<Balance> MENU_ITEM_MATCHER = MatcherFactory
    .usingEqualsComparator(Balance.class);
}
