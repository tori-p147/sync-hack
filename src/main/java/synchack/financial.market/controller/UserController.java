package synchack.financial.market.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import synchack.financial.market.config.auth.AuthProviderImpl;
import synchack.financial.market.dto.CredentialsDto;
import synchack.financial.market.error.UserException;
import synchack.financial.market.error.enums.ErrorCode;
import synchack.financial.market.model.user.User;
import synchack.financial.market.service.UserService;

import java.net.URI;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping(value = UserController.URL)
public class UserController {

    static final String URL = "/";
    private final AuthProviderImpl authProviderImpl;
    private final UserService userService;

    public UserController(AuthProviderImpl authProviderImpl, UserService userService) {
        this.authProviderImpl = authProviderImpl;
        this.userService = userService;
    }

    @Operation(summary = "sign in")
    @GetMapping("hakaton/v1/auth/sign_in")
    public ResponseEntity<ErrorCode> signIn(@RequestBody CredentialsDto credentials) {
        return getAuthority(credentials);
    }

    @Operation(summary = "sign up")
    @PostMapping("hakaton/v1/auth/sign_up")
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
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
