package demo.usecase.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "management_login")
public class ManagementLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mg_id;

	@Column(nullable = false, unique = true)
	private String user_name;

	@Column(nullable = false)
	private String password;

	private Timestamp last_login;

	public ManagementLogin() {
	}

	public ManagementLogin(String user_name, String password, Timestamp last_login) {
		this.user_name = user_name;
		this.password = password;
		this.last_login = last_login;
	}

	public int getMg_id() {
		return mg_id;
	}

	public void setMg_id(int mg_id) {
		this.mg_id = mg_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLast_login() {
		return last_login;
	}

	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}

}
