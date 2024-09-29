package md.electro.controller;

import lombok.AllArgsConstructor;
import md.electro.model.input.RegisterRequestExtended;
import md.electro.service.AccountService;
import md.kobalt.security.auth.AuthenticationRequest;
import md.kobalt.security.auth.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "auth")
@RequestMapping("api/v1/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequestExtended request) {
        accountService.register(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(accountService.authenticate(request));
    }
}
