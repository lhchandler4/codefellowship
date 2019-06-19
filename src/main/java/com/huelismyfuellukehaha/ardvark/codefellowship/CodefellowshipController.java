package com.huelismyfuellukehaha.ardvark.codefellowship;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class CodefellowshipController {

//    @GetMapping("/login")
//    public String getCodefellowship(Principal p, Model m) {
//        System.out.println(p.getName());
//        m.addAttribute("principal", p);
//        return "login.html";
//    }
}
