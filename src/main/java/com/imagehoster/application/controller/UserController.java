package com.imagehoster.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imagehoster.application.model.User;
import com.imagehoster.application.model.UserProfile;
import com.imagehoster.application.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //This controller method is called when the request pattern is of type 'users/registration'
    @RequestMapping("users/registration")
    public String registration(Model model) {
        //Complete this method
        //Observe User and UserProfile models implemented
        //Declare an object of User class and UserProfile class
        //Set the profile of the user as UserProfile type object
        //Add user in the model and return 'users/registration.html'
    	
    	UserProfile userProfile = new UserProfile();
    	userProfile.setEmailAddress("test@gmail.com");
    	userProfile.setFullName("Test ImageHoster");
    	userProfile.setId(123);
    	userProfile.setMobileNumber("9876543210");
    	User user = new User();
    	
    	user.setId(123);
    	user.setPassword("test");
    	user.setUsername("imageHoster");
    	user.setProfile(userProfile);

    	model.addAttribute("User", user);
    	
    	return "users/registration";
    }

    //This controller method is called when the request pattern is of type 'users/registration' and also the incoming request is of POST type
    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user) {
        //Complete this method
        //Call the business logic which currently does not store the details of the user in the database
        //After registration, again redirect to the registration page
    	userService.registerUser(user);
        return "redirect:/users/login";
    }
    
  //This controller method is called when the request pattern is of type 'users/login'
    @RequestMapping("users/login")
    public String login() {
        //Complete this method to return the 'users/login.html'
    	return "users/login";
    }

    //This controller method is called when the request pattern is of type 'users/login' and also the incoming request is of POST type
    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginUser(User user) {
        //Complete this method
        //The method calls the login() method passing user as an argument
        //If login() method returns true, successful login, direct to the method mapped with request of type '/images'
        //If login() method returns false, unsuccessful login, redirect to the same login page
    	if(userService.login(user))
    		return "redirect:/images";
    	
    	return "users/login";
    }
}