package demo.usecase.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {

@Id
	private Long id;
	private String name;
	private String email;
	private Long status;

	public void setAdminId(Long id) {
		this.id = id;
	}

	public Long getAdminId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getStatus() {
		return status;
	}
}
