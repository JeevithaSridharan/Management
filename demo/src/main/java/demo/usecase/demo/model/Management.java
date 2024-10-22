package demo.usecase.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Management {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String mg_name;
	@Column(nullable = false, unique = true)
	private String email;
	private long status;
	private Date created_on;

	public Management() {
		this.created_on = new Date();
	}

	public Management(String mg_name, String email, int status) {
		this.mg_name = mg_name;
		this.email = email;
		this.status = status;
		this.created_on = new Date();
	}

	public void setId(Long id) {
		this.id = (long) id;
	}

	public Long getId() {
		return this.id;
	}

	public void setMg_name(String mg_name) {
		this.mg_name = mg_name;
	}

	public String getMg_name() {
		return this.mg_name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getStatus() {
		return this.status;
	}

	public void setCreatedOn(Date created_on) {
		this.created_on = created_on;
	}

	public Date getCreatedOn() {
		return this.created_on;
	}
}