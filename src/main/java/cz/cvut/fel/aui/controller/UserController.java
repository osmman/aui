package cz.cvut.fel.aui.controller;

import cz.cvut.fel.aui.service.UserService;
import cz.cvut.fel.aui.model.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tomáš
 * Date: 15.11.13
 * Time: 20:41
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class UserController extends BaseController
{

    @Produces
    @Named
    private User newUser;

    @Inject
    private UserService userDao;

    @Inject
    private FacesContext facesContext;

    @PostConstruct
    public void initUser()
    {
        newUser = new User();
    }

    public void createUser()
    {
        userDao.create(newUser);
        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Created", "Registration successful");
        facesContext.addMessage(null, m);
        initUser();
    }

    public void edit()
    {
        userDao.edit(newUser);
        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Edited", "Registration successful");
        facesContext.addMessage(null, m);
        initUser();
    }

    public void delete(){
        userDao.remove(newUser);
        initUser();
    }

    public List<User> getUsers()
    {
        return userDao.findAll();
    }


}
