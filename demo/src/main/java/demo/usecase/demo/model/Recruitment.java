package demo.usecase.demo.model;

import javax.persistence.*;

@Entity
public class Recruitment {

	@Column(nullable = false)
	private int mg_id;

	@Column(nullable = false)
	private int player_id;

	public Recruitment() {
	}

	public Recruitment(int mg_id, int player_id) {
		this.mg_id = mg_id;
		this.player_id = player_id;
	}

	public int getMg_id() {
		return mg_id;
	}

	public void setMg_id(int mg_id) {
		this.mg_id = mg_id;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

}
