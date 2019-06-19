package com.huelismyfuellukehaha.ardvark.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class AppUserController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public RedirectView goLogin(){
        return new RedirectView("/login");
    }

    @GetMapping("/users")
    public String getAllUsers(Model m, Principal p) {
        Iterable<AppUser> user = appUserRepository.findAll();
        m.addAttribute("user", user);
        AppUser name = appUserRepository.findByUsername(p.getName());
        m.addAttribute("name", name);
        return "users.html";
    }

    @RequestMapping(value="details/{id}",method = RequestMethod.GET)
    public String getOneUserDetail(@PathVariable Long id, Model m){
        AppUser user = appUserRepository.findById(id).get();
        m.addAttribute("user", user);
        return "details.html";
    }

//    @GetMapping("/login")
//    public String getLoginPage(Principal p, Model m) {
//        System.out.println(p.getName());
//        m.addAttribute("principal", p);
//        return "login.html";
//    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String getAddSignUpForm() {
        return "signup.html";
    }

    @PostMapping("/signup")
    public RedirectView addUser(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, @RequestParam Date dateOfBirth, @RequestParam String bio) {
        AppUser user = new AppUser(username, bCryptPasswordEncoder.encode(password), firstName, lastName, dateOfBirth, bio);
        appUserRepository.save(user);
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/myprofile");
    }

    @GetMapping("/myprofile")
    public String getMyProfileInfo(Principal p, Model m) {
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("user", user);
        return "myprofile.html";
    }

    @GetMapping("/codefellowshipOfTheRing")
    public String getRingForm(Model m, Principal p) {
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("user", user);
        return "codefellowshipOfTheRing.html";
    }

    @GetMapping("/logout_completed")
    public String getLogoutPage() {
        return "logout_completed.html";
    }
}
