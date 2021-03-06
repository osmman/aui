package cz.cvut.fel.aui.controller;

import cz.cvut.fel.aui.model.Address;
import cz.cvut.fel.aui.model.Context;
import cz.cvut.fel.aui.model.Person;
import cz.cvut.fel.aui.model.PersonInfo;
import cz.cvut.fel.aui.service.ContextService;
import cz.cvut.fel.aui.service.PersonService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Person: Tomáš
 * Date: 15.11.13
 * Time: 20:41
 * To change this template use File | Settings | File Templates.
 */
@Model
public class PersonController extends BaseController
{

    @Produces
    @Named
    private Person newPerson;

    private Long id;

    @Produces
    @Named
    private Person person;

    @Inject
    private PersonService personService;

    @Inject
    private FacesContext facesContext;

    @Inject
    private ContextService contextService;

    @PostConstruct
    public void initUser()
    {
        Context context = contextService.getContext();
        newPerson = new Person();
        newPerson.setPersonInfo(new PersonInfo());
        onContextChanged(context);
    }

    public void onContextChanged(@Observes Context context){
        newPerson.getPersonInfo().getAddress().setCountry(context.getCountry());
    }

    public void loadPerson(){
        if (id != null) {
            person = personService.find(id);
            if (person.getPersonInfo() == null) {
                person.setPersonInfo(new PersonInfo());
            }
        }
    }

    public String create()
    {
        personService.create(newPerson);
        initUser();
        return redirect("people");
    }

    public String edit(Person person)
    {
        personService.edit(person);
        return redirect("person",true);
    }

    public String delete(Person person)
    {
        personService.remove(person);
        return redirect("people");
    }

    public String delete(){
        loadPerson();
        personService.remove(person);
        return redirect("people");
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<Person> getAll()
    {
        List<Person> list = personService.findAll();
        return list;
    }

}
