package synchack.financial.market.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import synchack.financial.market.config.auth.AuthProviderImpl;
import synchack.financial.market.dto.CredentialsDto;
import synchack.financial.market.error.enums.ErrorCode;
import synchack.financial.market.model.user.User;
import synchack.financial.market.service.UserService;

import java.net.URI;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping(value = UserController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    static final String URL = "hakaton/v1/auth";
    private final AuthProviderImpl authProviderImpl;
    private final UserService userService;

    public UserController(AuthProviderImpl authProviderImpl, UserService userService) {
        this.authProviderImpl = authProviderImpl;
        this.userService = userService;
    }

    @GetMapping("sign_in")
    public ResponseEntity<ErrorCode> signIn(@RequestBody CredentialsDto credentials) {
        return getAuthority(credentials);
    }

    @PostMapping("sign_up")
    public ResponseEntity<User> signUp(@RequestBody CredentialsDto credentials) {
        User user = userService.createUser(credentials);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(user);
    }

    private ResponseEntity<ErrorCode> getAuthority(CredentialsDto credentials){
        Authentication authentication = authProviderImpl.authenticate(credentials);
        if (!isEmpty(authentication)) {
            if (!authentication.isAuthenticated()){
                return new ResponseEntity<>(ErrorCode.USER_001, HttpStatus.FORBIDDEN);
            } else
                return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
