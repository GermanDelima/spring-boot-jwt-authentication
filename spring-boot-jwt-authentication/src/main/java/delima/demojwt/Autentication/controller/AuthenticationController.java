package delima.demojwt.Autentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping(value = "register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
    return ResponseEntity.ok(authenticationService.register(request));
  }
  @PostMapping(value = "login")
  public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
    return ResponseEntity.ok(authenticationService.login(request));
  }
}
