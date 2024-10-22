package demo.usecase.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Approval {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long admin_id;
	private Long player_id;
	private String reason;
	private int status; // e.g., 1 for approved, 0 for rejected 
	private LocalDateTime approval_time;

	public void setAdmin_id(Long admin_Id) {
		this.admin_id = admin_Id;
	}

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public Long getPlayer_id() {
		return player_id;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setStatus(int l) {
		this.status = l;
	}

	public int getStatus() {
		return status;
	}

	public void setApproval_time(LocalDateTime now) {
		this.approval_time = now;
	}

	public LocalDateTime getApproval_time() {
		return approval_time;
	}

}
