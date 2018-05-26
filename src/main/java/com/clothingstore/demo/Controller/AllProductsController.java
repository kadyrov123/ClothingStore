package com.clothingstore.demo.Controller;

import com.clothingstore.demo.Dao.Dao;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class AllProductsController {
    @Autowired
    Dao dao;


    @RequestMapping("/products")
    public String all(ModelMap map){
        map.addAttribute("products" ,dao.getAllProducts());
        return "all_products.html";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, ModelMap map){
        map.addAttribute("products" , dao.search(search));
        return "all_products";
    }

}
