package synchack.financial.market.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import synchack.financial.market.config.auth.AuthProviderImpl;
import synchack.financial.market.dto.CredentialsDto;
import synchack.financial.market.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

    private final AuthProviderImpl authProviderImpl;
    private final UserService userService;

    public UserController(AuthProviderImpl authProviderImpl, UserService userService) {
        this.authProviderImpl = authProviderImpl;
        this.userService = userService;
    }

    @GetMapping("login")
    public Authentication login(@RequestBody CredentialsDto credentials) {
        return authProviderImpl.authenticate(credentials);
    }

    @GetMapping("user/test")
    public String test(){
        return userService.returnString();
    }
}
