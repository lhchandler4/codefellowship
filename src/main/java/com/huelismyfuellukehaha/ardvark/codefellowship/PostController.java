package com.huelismyfuellukehaha.ardvark.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;

@Controller
public class PostController {

    @Autowired
    PostRepository postsRepository;

    @Autowired
    AppUserRepository appUserRepository;

//    @GetMapping("/")
//    public String getPosts(Principal p, Model m) {
//        System.out.println(p.getName());
//        AppUser me = appUserRepository.findByUsername(p.getName());
//
//        m.addAttribute("loggedInUser", me);
//        return "posts";
//    }

    @GetMapping("/createpost")
    public String getPostCreator(Model m, Principal p) {
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("user", user);
        return "createPost";
    }

    @PostMapping("/posts")
    public RedirectView addDinosaur(String body, Date createdAt, Principal p, Model m) {
        Post newPost = new Post();
        newPost.body = body;
        newPost.createdAt = createdAt;
        AppUser me = appUserRepository.findByUsername(p.getName());
        newPost.creator = me;
        postsRepository.save(newPost);
        m.addAttribute("user", me);
        return new RedirectView("/myprofile");
    }

    @GetMapping("/posts/{id}")
    public String showDinosaur(@PathVariable long id, Model m, Principal p) {
        Post post = postsRepository.findById(id).get();
        // check if that post belongs to the currently logged in user
        if (post.getCreator().username.equals(p.getName())) {
            m.addAttribute("post", post);
            return "posts";
        } else {
            throw new PostIsNotYoursException("That post is not yours.");
        }


    }
}

// came from https://stackoverflow.com/questions/2066946/trigger-404-in-spring-mvc-controller
@ResponseStatus(value = HttpStatus.FORBIDDEN)
class PostIsNotYoursException extends RuntimeException {
    public PostIsNotYoursException(String s) {
        super(s);
    }

}
