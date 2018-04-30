package com.clothingstore.demo.Controller;

import com.clothingstore.demo.Dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AllProductsController {

    Dao dao;

    @RequestMapping("/")
    public String home(){
        return "home.html";
    }

    @RequestMapping("/all_products")
    public String all(ModelMap map){
        map.addAttribute("products" ,dao.getAllProducts());
        return "all_products";
    }


}
