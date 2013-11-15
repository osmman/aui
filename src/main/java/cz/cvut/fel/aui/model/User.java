package cz.cvut.fel.aui.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Tomáš
 * Date: 15.11.13
 * Time: 19:55
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "users")
public class User extends EntityObject {

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String email;

    private String firstname;
    private String surname;

//    @ElementCollection(targetClass = Role.class)
//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "user_role")
//    @Column(name = "role")
//    private Set<Role> roles = new HashSet<Role>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
