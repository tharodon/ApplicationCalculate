package ru.pavlov.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest servletRequest){
//        String name = servletRequest.getParameter("name");
//        String surname = servletRequest.getParameter("surname");
//
//        System.out.println("Hello, " + name + " " + surname);
//        return "first/hello";
//    }
//    private int calculator (int x, char oper, int y){
//        if (oper == '+')
//            return x + y;
//        else if (oper == '-')
//            return x - y;
//        else if (oper == '*')
//            return x * y;
//        else if (oper == '/')
//            return x / y;
//        return 0;
//    }
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model){
        model.addAttribute("Hello, " + name + " " + surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String pokaPage() {
        return "first/Goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam("x") int x, @RequestParam("oper") String oper, @RequestParam("y") int y, Model model){
        double res = 0;
        System.out.println(oper + oper.charAt(0));
        if (oper.contains("plus"))
            res =  x + y;
        else if (oper.charAt(0) == '-')
            res =  x - y;
        else if (oper.charAt(0) == '*')
            res =  x * y;
        else if (oper.charAt(0) == '/')
            res =  x / (double)y;
        model.addAttribute("result", res);
        return "first/calculator";
    }
}
