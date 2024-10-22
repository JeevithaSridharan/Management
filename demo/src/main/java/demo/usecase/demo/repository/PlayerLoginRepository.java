package demo.usecase.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.usecase.demo.model.PlayerLogin;

@Repository
public interface PlayerLoginRepository extends JpaRepository<PlayerLogin, Long> {
 

	PlayerLogin save(Long id);



}
