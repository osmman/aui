package cz.cvut.fel.aui.controller;

import cz.cvut.fel.aui.model.Person;
import cz.cvut.fel.aui.model.PersonInfo;
import cz.cvut.fel.aui.model.context.Age;
import cz.cvut.fel.aui.model.context.Device;
import cz.cvut.fel.aui.model.context.ScreenSize;
import cz.cvut.fel.aui.service.PersonService;
import cz.cvut.fel.aui.utils.comparator.ValueComparator;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Person: Tomáš
 * Date: 30.11.13
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
@Named
@Startup
@Singleton
public class Data
{
    public Age[] getAges(){
        return Age.values();
    }

    public ScreenSize[] getScreenSizes(){
        return ScreenSize.values();
    }

    public Map<String, String> getCountries(){
        Map<String,String> countries = new HashMap<String, String>();
        for(String countryCode: Locale.getISOCountries()){
            Locale obj = new Locale("",countryCode);
            countries.put(countryCode,obj.getDisplayCountry());
        }

        ValueComparator comparator = new ValueComparator(countries);
        Map<String, String>sorted = new TreeMap<String, String>(comparator);
        sorted.putAll(countries);
        return sorted;
    }

    public Device[] getDevices(){
        return Device.values();
    }

    public PersonInfo.Gender[] getGender(){
        return PersonInfo.Gender.values();
    }

    @Inject
    @PostConstruct
    protected void init(PersonService personService){
        personService.create(new Person("osmman@gmail.com","heslo"));
        personService.create(new Person("asdas@gmail.com","heslo"));
    }
}
