package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by AtagaN on 28.01.2019.
 */

@Controller
public class MyController {

    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String hello(Model model) {
        return "hello";
    }
}
