package synchack.financial.market.service;

import org.springframework.security.access.prepost.PreAuthorize;
import synchack.financial.market.model.user.BaseUser;

public interface UserService {


    public BaseUser getUserByUserName(String userName);

    default String returnString(){
        return "string";
    }
}
