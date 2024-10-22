package demo.usecase.demo.model;

import javax.persistence.*;

import com.sun.istack.NotNull;

import java.sql.Timestamp;

@Entity
@Table(name = "AdminLogin")
public class AdminLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long admin_id;

    @NotNull
    private String user_name;

	@Column(nullable = false)
	private String password;

	private Timestamp lastlogin;


	// Getters and Setters
	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setLast_login(Timestamp last_login) {
		this.lastlogin = last_login;
	}

	public Timestamp getLast_login() {
		return lastlogin;
	}

}
