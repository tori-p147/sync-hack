package synchack.financial.market.service;

import org.springframework.stereotype.Component;
import synchack.financial.market.model.user.User;
import synchack.financial.market.model.user.Role;

@Component
public class UserServiceImpl implements UserService{

    /**
     * пока создала мок
     */
    @Override
    public User getUserByUserName(String userName) {
        return new User("user", "email.gmail.com", true, "$2a$12$9tWrzyak6cuaEKc3M6jJ4e5TjzRn7.FjAzIK3yv5WqFt3P.oyOzEK", Role.USER);
    }
}
