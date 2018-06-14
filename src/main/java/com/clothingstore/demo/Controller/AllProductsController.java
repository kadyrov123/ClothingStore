package com.clothingstore.demo.Controller;

import com.clothingstore.demo.Dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AllProductsController {
    @Autowired
    Dao dao;


    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, ModelMap map){
        map.addAttribute("products" , dao.search(search));
        return "shop";
    }

    @RequestMapping("/getProduct")
    public String getProduct(@RequestParam("id")int id , ModelMap m){
        m.addAttribute("u", dao.getProduct(id));
        return "single";
    }

    @RequestMapping("/bin")
    public String bin(@RequestParam("id")int id , ModelMap m){
        //dao.addToBin(id);
        m.addAttribute("products" ,dao.getAllProducts());
        return "shop";
    }


}
