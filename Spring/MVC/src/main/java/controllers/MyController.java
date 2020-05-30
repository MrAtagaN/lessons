package controllers;

import model.MyException;
import model.MyException2;
import model.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Доки - https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc
 */
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

    @GetMapping(value = "/exception")
    @ResponseBody
    public String myForm() {
        throw new MyException2();
    }
}
