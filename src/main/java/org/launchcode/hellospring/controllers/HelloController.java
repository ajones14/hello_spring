package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
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
    public String goodbye() {
        return "Goodbye, spring!";
    }

    @PostMapping("hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        return this.createMessage(name, language);
    }

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name;
    }

    @GetMapping
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +

                "<select name='language'>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='french'>French</option>" +
                "</select>" +

                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
