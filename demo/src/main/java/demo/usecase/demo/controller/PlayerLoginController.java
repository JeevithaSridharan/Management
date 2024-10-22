package demo.usecase.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.usecase.demo.model.Admin;
import demo.usecase.demo.model.AdminLogin;
import demo.usecase.demo.model.Player;
import demo.usecase.demo.model.PlayerLogin;
import demo.usecase.demo.service.Impl.PlayerServiceImpl;


	@RestController
	@RequestMapping("/user")
	public class PlayerLoginController {

		@Autowired
		private PlayerServiceImpl playerService;

		@GetMapping("/all")
		public List<PlayerLogin> getPlayers() {
			return playerService.findAll();
		}

		@PostMapping("/create")
		public ResponseEntity<PlayerLogin> createPlayer(@RequestBody PlayerLogin playerLogin) {
			PlayerLogin newPlayer = new PlayerLogin();
			newPlayer.setUser_name(playerLogin.getUser_name());
			newPlayer.setPassword(playerLogin.getPassword());
			newPlayer.setLast_login(new Timestamp(System.currentTimeMillis()));
			PlayerLogin savedPlayer = playerService.createPlayer(newPlayer);
			return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
		}
		

		@GetMapping("/all/{id}")
		public PlayerLogin getPlayerById(@PathVariable Long id) {
			return playerService.findById(id);
		}

		@PutMapping("/{id}")
		public PlayerLogin updatePlayer(@PathVariable Long id, @RequestBody PlayerLogin player) {
			return playerService.update(id, player);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
			playerService.deleteById(id);
			return ResponseEntity.ok("Player with ID " + id + " was deleted successfully.");
		}
		
		
		
		@PostMapping("/createProfile")
	    public ResponseEntity<Player> createUser(@RequestBody Player player, @RequestParam Long player_id) {
	        Player savedPlayer = playerService.createUser(player, player_id);
	        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
	    }

		
		

	}
