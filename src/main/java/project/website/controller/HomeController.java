package project.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import project.website.domain.Post;
import project.website.service.PostService;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    private PostService postService;

    @Autowired
    public HomeController(PostService postService){
        this.postService = postService;
    }

    @GetMapping({"","/"})
    public String Home(@PageableDefault Pageable pageable, Model model){
        Page<Post> posts = postService.getAllPosts(pageable);
        model.addAttribute("Posts", posts);
        return "home";
    }
}
