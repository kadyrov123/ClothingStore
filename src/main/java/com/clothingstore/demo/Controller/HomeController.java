package com.clothingstore.demo.Controller;

import com.clothingstore.demo.Dao.Dao;
import com.clothingstore.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    Dao dao;

    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("/home")
    public String home2(){
        return "index";
    }

    /*
    =========================== Authorization ==================================
     */
    @RequestMapping("/login")
    public String l(){
        return "login";
    }

    @RequestMapping(value = "/registr" , method = RequestMethod.POST)
    public String registr(User user , ModelMap m){
        dao.registr(user);
        m.addAttribute("products" , dao.getAllProducts());
        return "shop";
    }

    @RequestMapping(value = "/shop")
    public String login( ModelMap m){
        m.addAttribute("products",dao.getAllProducts());
        return "shop";
    }

}
