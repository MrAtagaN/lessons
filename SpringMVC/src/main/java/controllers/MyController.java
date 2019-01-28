package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by AtagaN on 28.01.2019.
 */

@Controller
public class MyController {

    @RequestMapping(value = "/myForm", method= RequestMethod.GET)
    public String myForm(Model model) {
        return "myForm";
    }

    @PostMapping(value = "/myForm")
    @ResponseBody
    public String myForm(@RequestParam String name,@RequestParam int age) {
        return name + "  " + age;
    }
}
