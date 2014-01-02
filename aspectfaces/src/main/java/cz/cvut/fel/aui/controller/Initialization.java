package cz.cvut.fel.aui.controller;

import cz.cvut.fel.aui.model.Person;
import cz.cvut.fel.aui.model.PersonInfo;
import cz.cvut.fel.aui.service.PersonService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by Tomáš on 27.12.13.
 */
@Startup
@Singleton
public class Initialization
{

    @Inject
    private PersonService personService;

    @PostConstruct
    public void deploy(){
        Person p1 = new Person("osmman@gmail.com","heslo");
        PersonInfo info = new PersonInfo();
        info.setFirstName("Tomas");
        info.setLastName("Turek");
        info.setGender(PersonInfo.Gender.MALE);
        p1.setPersonInfo(info);

        personService.create(p1);


        Person p2 = new Person("test@email.com","heslo");
        PersonInfo info2 = new PersonInfo();
        info2.setFirstName("Test");
        info2.setLastName("Test");
        info2.setGender(PersonInfo.Gender.FEMALE);
        p2.setPersonInfo(info2);
        personService.create(p2);
    }
}
