package delima.demojwt.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
  //metodo para requerrir metodo mas espesifico para buscar por username
  Optional<UserEntity> findByUsername(String username);

}
