package com.flocondria.fridge.authentification.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flocondria.fridge.authentification.domain.User;

@Controller
public class UserController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome() {
        return "hello";
    }
}
