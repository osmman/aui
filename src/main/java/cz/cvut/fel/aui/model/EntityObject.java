package cz.cvut.fel.aui.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Tomáš
 * Date: 15.11.13
 * Time: 19:51
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public class EntityObject implements Serializable {

    protected Long id;

    public EntityObject() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)[%s]", getClass().getSimpleName(), getId(), super.toString());
    }
}