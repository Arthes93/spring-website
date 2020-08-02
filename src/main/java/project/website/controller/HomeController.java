package project.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import project.website.domain.Post;
import project.website.service.PostService;

@Controller
public class HomeController {

    private PostService postService;

    @Autowired
    public HomeController(PostService postService){
        this.postService = postService;
    }

    @GetMapping({"","/"})
    public String Home(){
        return "home";
    }

    @GetMapping({"/post"})
    public String content(){
        return "post";
    }

    @GetMapping("/post/{num}")
    public String Post(@PathVariable Long num, Model model){
        Post post = postService.getPost(num);
        model.addAttribute("post", post);
        return "post";
    }
}
