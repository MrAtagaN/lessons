package com.plekhanov.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by AtagaN on 23.01.2019.
 */
@Controller
public class MainController {

    @RequestMapping(value ="/hello")
    @ResponseBody
    public String hello() {
        return "Hello World! from controller";
    }
}
