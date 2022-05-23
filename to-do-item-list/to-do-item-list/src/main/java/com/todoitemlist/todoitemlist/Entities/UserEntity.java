package com.todoitemlist.todoitemlist.Entities;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(unique=true,name = "email")
    private  String email;
    private String Password;
    private Instant createdTimestamp ;
    private Instant updatedTimestamp;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String _email) {
        email = _email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Instant getDateCreated() {
        return createdTimestamp;
    }

    public void setDateCreated(Instant dateCreated) {
        this.createdTimestamp = dateCreated;
    }

    public Instant getDateModified() {
        return updatedTimestamp;
    }

    public void setDateModified(Instant dateModified) {
        this.updatedTimestamp = dateModified;
    }
}
