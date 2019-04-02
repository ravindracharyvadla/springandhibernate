package com.companyname.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.service.LoginService;

@Controller
//@RequestMapping("/user")
public class LoginController {
 
    @Autowired
    private LoginService loginService;            // This will auto-inject the authentication service into the controller.
 
   /* private static Logger log = Logger.getLogger(LoginCtrl.class);*/
 
    // Checks if the user credentials are valid or not.
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ModelAndView validateUsr(@RequestParam("emailId")String emailId, @RequestParam("password")String password) {
        String msg = "";
        boolean isValid = loginService.findUser(emailId, password);
        /*log.info("Is user valid?= " + isValid);*/
 
        if(isValid) {
            msg = "Welcome: " + emailId;
            return new ModelAndView("loginSuccessPage", "output", msg);
        } else {
            msg = "Invalid credentials";
            return new ModelAndView("loginFailedPage", "output", msg);
        }
 
        //return new ModelAndView("result", "output", msg);
    }
}
