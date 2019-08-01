package controllers;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class MyController {


    @RequestMapping(value = "/myForm", method = RequestMethod.GET)
    public Product myForm(Model model) {
        return new Product("chesse","Russian", 25); //TODO добавить конвертер
    }


    @PostMapping(value = "/myForm")
    @ResponseBody
    public String myForm(@RequestParam String name, @RequestParam int age) {
        return name + "  " + age;
    }
}
