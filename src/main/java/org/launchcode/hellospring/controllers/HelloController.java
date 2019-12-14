package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    public static String createMessage(String name, String language) {
        if (language.equals("english")) {
            return "Hey, " + name + "!";
        } else if (language.equals("spanish")) {
            return "Hola, " + name + "!";
        } else if (language.equals("german")) {
            return "Hallo, " + name + "!";
        } else if (language.equals("italian")) {
            return "Ciao, " + name + "!";
        } else if (language.equals("french")) {
            return "Bonjour, " + name + "!";
        }
        return "Hello!";
    }

//    @GetMapping("hello")
//    public String hello() {
//        return "Hello, spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, spring!";
    }

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name;
    }

    @GetMapping
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Abigail");
        names.add("Christian");
        names.add("Elijah");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
