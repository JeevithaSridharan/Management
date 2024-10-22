package demo.usecase.demo.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class Player {

    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private long status;

    @Column(nullable = false)
    private LocalDateTime created_on;

    @Column(nullable = false)
    private LocalDateTime updated_on;

    @Column(nullable = true)
    private String cv_filepath;

    @Column(nullable = false)
    private long phone_number;

    // Getters and setters

    public long getPlayer_id() {
        return id;
    }

    public void setPlayer_id(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public LocalDateTime getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(LocalDateTime updated_on) {
        this.updated_on = updated_on;
    }

    public String getCv_filepath() {
        return cv_filepath;
    }

    public void setCv_filepath(String cv_filepath) {
        this.cv_filepath = cv_filepath;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }
}
