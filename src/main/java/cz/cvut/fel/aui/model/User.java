package cz.cvut.fel.aui.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Tomáš
 * Date: 15.11.13
 * Time: 19:55
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class User extends EntityObject
{

    @NotNull
    @Size(min = 1, max = 60)
    private String username;

    private String password;

    private String email;

    private String firstname;

    private String surname;

    @OneToMany(mappedBy = "owner")
    private Set<Car> cars;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public Set<Car> getCars()
    {
        return cars;
    }

    public void setCars(Set<Car> cars)
    {
        this.cars = cars;
    }
}
