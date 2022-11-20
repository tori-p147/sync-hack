package synchack.financial.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import synchack.financial.market.dto.CredentialsDto;
import synchack.financial.market.model.user.Role;
import synchack.financial.market.model.user.User;
import synchack.financial.market.repository.UserRepository;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByUserName(String userName) {
        User user = userRepository.getUserByUserName(userName).get();
        System.out.println(user.toString());
        return userRepository.getUserByUserName(userName);
    }

    public User createUser(CredentialsDto credentialsDto) {
        return userRepository.save(
                new User(
                        credentialsDto.getUsername(),
                        credentialsDto.getEmail(),
                        false,
                        bCryptPasswordEncoder.encode(credentialsDto.getPassword()),
                        new ArrayList<>(Collections.singleton(new Role("USER")))
                ));
    }
}
