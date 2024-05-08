package delima.demojwt.Autentication.controller;


import delima.demojwt.jwt.JwtService;
import delima.demojwt.user.Role;
import delima.demojwt.user.UserEntity;
import delima.demojwt.user.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserEntityRepository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse login(LoginRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
    String token=jwtService.getToken(user);
    return AuthenticationResponse.builder()
        .token(token)
        .build();

  }

  public AuthenticationResponse register(RegisterRequest request) {
    UserEntity user = UserEntity.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode( request.getPassword()))
        .firstname(request.getFirstname())
        .lastname(request.lastname)
        .country(request.getCountry())
        .role(Role.ADMIN)
        .build();

    userRepository.save(user);

    return AuthenticationResponse.builder()
        .token(jwtService.getToken(user))
        .build();

  }

}
