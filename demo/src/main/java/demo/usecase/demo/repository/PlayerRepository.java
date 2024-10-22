package demo.usecase.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.usecase.demo.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {



	Player save(Player player);

}
