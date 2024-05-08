package delima.demojwt.Autentication.controller;

import delima.demojwt.jwt.JwtService;
import delima.demojwt.user.Role;
import delima.demojwt.user.UserEntity;
import delima.demojwt.user.UserEntityRepository;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
  String token;


}
