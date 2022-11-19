package synchack.financial.market.service;

import org.springframework.stereotype.Component;
import synchack.financial.market.model.user.BaseUser;
import synchack.financial.market.model.user.Client;
import synchack.financial.market.model.user.Role;

@Component
public class UserServiceImpl implements UserService{

    /**
     * пока создала мок
     */
    @Override
    public BaseUser getUserByUserName(String userName) {
        return new Client("user", "email.gmail.com", true, "$2a$12$9tWrzyak6cuaEKc3M6jJ4e5TjzRn7.FjAzIK3yv5WqFt3P.oyOzEK", Role.USER);
    }
}
