package demo.usecase.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class PlayerLogin  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long player_id;

    @Column(nullable = false, unique = true)
    private String user_name;

    @Column(nullable = false)
    private String password;

    private Timestamp last_login;
 
    public Long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Long player_id) {
        this.player_id = player_id;
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
