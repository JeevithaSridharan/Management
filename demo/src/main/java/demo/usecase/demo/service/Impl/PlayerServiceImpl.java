package demo.usecase.demo.service.Impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import demo.usecase.demo.model.Approval;
import demo.usecase.demo.model.ApprovalRepository;
import demo.usecase.demo.model.Player;
import demo.usecase.demo.model.PlayerLogin;
import demo.usecase.demo.repository.PlayerLoginRepository;
import demo.usecase.demo.repository.PlayerRepository;

@Service
public class PlayerServiceImpl {

	@Autowired
	private PlayerLoginRepository playerLoginRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private ApprovalRepository approvalRepository;

	public PlayerLogin createPlayer(PlayerLogin playerLogin) {
		if (playerLogin.getUser_name() == null) {
			throw new IllegalArgumentException("Username cannot be null");
		}
		playerLogin.setLast_login(new Timestamp(System.currentTimeMillis()));
		return playerLoginRepository.save(playerLogin);
	}

	public List<PlayerLogin> findAll() {
		return playerLoginRepository.findAll();
	}

	public PlayerLogin findById(Long id) {
		Optional<PlayerLogin> player = playerLoginRepository.findById(id);
		return player.orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));
	}

	public PlayerLogin update(Long id, PlayerLogin player) {

		if (!playerLoginRepository.existsById(id)) {
			throw new RuntimeException("Player not found with ID: " + id);
		}
		player.setPlayer_id(id);
		return playerLoginRepository.save(player);
	}

	public void deleteById(Long id) {
		if (playerLoginRepository.existsById(id)) {
			playerLoginRepository.deleteById(id);
		} else {
			throw new RuntimeException("Player not found with ID: " + id);
		}
	}

	public Player createUser(Player player, Long player_id) {
		if (playerLoginRepository.existsById(player_id)) {
			if (playerRepository.existsById(player_id)) {
				throw new ResponseStatusException(HttpStatus.CONFLICT,
						"Player with ID: " + player_id + " already exists.");
			}
			player.setPlayer_id(player_id);
			LocalDateTime now = LocalDateTime.now();
			player.setCreated_on(now);
			player.setUpdated_on(now);
			Player savedPlayer = playerRepository.save(player);
			Approval approval = new Approval();
			approval.setPlayer_id(savedPlayer.getPlayer_id());
			approval.setStatus(0); // Status 0 for "pending"
			approval.setReason("Awaiting approval");
			approvalRepository.save(approval);

			return savedPlayer;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found with ID: " + player_id);
		}
	}

}
