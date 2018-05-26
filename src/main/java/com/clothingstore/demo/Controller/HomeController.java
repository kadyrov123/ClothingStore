package com.clothingstore.demo.Controller;

import com.clothingstore.demo.Dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    Dao dao;

    @RequestMapping("/")
    public String home(){
        return "home.html";
    }
}
