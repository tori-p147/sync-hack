package synchack.financial.market.service;

import synchack.financial.market.model.user.User;

public interface UserService {


  public User getUserByUserName(String userName);

  default String returnString() {
    return "string";
  }
}
