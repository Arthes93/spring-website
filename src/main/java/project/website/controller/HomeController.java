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

    @GetMapping("/post/{num}")
    public String Post(@PathVariable Long num, Model model){
        Post post = postService.getPost(num);
        model.addAttribute("Post", post);
        return "post";
    }

    @PostConstruct
    public void init(){
        Post post = Post.builder()
                .title("test1")
                .subtitle("test1")
                .content("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Purus in massa tempor nec feugiat nisl pretium. Vehicula ipsum a arcu cursus. At auctor urna nunc id cursus metus aliquam eleifend mi. Nunc mattis enim ut tellus elementum sagittis. Sed euismod nisi porta lorem. Praesent elementum facilisis leo vel fringilla. Placerat in egestas erat imperdiet sed euismod nisi porta lorem. Ipsum nunc aliquet bibendum enim facilisis gravida neque convallis a. Quis lectus nulla at volutpat diam. Erat velit scelerisque in dictum. Nisl suscipit adipiscing bibendum est ultricies. Aenean vel elit scelerisque mauris pellentesque pulvinar pellentesque habitant. Etiam sit amet nisl purus in mollis nunc.\n" +
                        "\n" +
                        "Ante in nibh mauris cursus. Adipiscing at in tellus integer. Placerat duis ultricies lacus sed turpis tincidunt id. Consequat interdum varius sit amet. Tortor aliquam nulla facilisi cras. Elementum tempus egestas sed sed. Ut tortor pretium viverra suspendisse potenti nullam ac tortor. Duis tristique sollicitudin nibh sit amet commodo nulla. Nibh sed pulvinar proin gravida. Eleifend quam adipiscing vitae proin sagittis nisl rhoncus mattis rhoncus. Volutpat est velit egestas dui id ornare arcu. Aliquam vestibulum morbi blandit cursus risus at ultrices. Nibh sed pulvinar proin gravida hendrerit lectus. Faucibus ornare suspendisse sed nisi lacus sed viverra tellus in. Pellentesque id nibh tortor id aliquet lectus proin nibh nisl. Aenean et tortor at risus viverra adipiscing at in. Iaculis urna id volutpat lacus laoreet non curabitur gravida.")
                .author("양동우")
                .createdTime(LocalDateTime.now())
                .updatedTime(LocalDateTime.now())
                .build();
        postService.savePost(post);

        Post post2 = Post.builder()
                .title("test2")
                .subtitle("test2")
                .content("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Purus in massa tempor nec feugiat nisl pretium. Vehicula ipsum a arcu cursus. At auctor urna nunc id cursus metus aliquam eleifend mi. Nunc mattis enim ut tellus elementum sagittis. Sed euismod nisi porta lorem. Praesent elementum facilisis leo vel fringilla. Placerat in egestas erat imperdiet sed euismod nisi porta lorem. Ipsum nunc aliquet bibendum enim facilisis gravida neque convallis a. Quis lectus nulla at volutpat diam. Erat velit scelerisque in dictum. Nisl suscipit adipiscing bibendum est ultricies. Aenean vel elit scelerisque mauris pellentesque pulvinar pellentesque habitant. Etiam sit amet nisl purus in mollis nunc.\n" +
                        "\n" +
                        "Ante in nibh mauris cursus. Adipiscing at in tellus integer. Placerat duis ultricies lacus sed turpis tincidunt id. Consequat interdum varius sit amet. Tortor aliquam nulla facilisi cras. Elementum tempus egestas sed sed. Ut tortor pretium viverra suspendisse potenti nullam ac tortor. Duis tristique sollicitudin nibh sit amet commodo nulla. Nibh sed pulvinar proin gravida. Eleifend quam adipiscing vitae proin sagittis nisl rhoncus mattis rhoncus. Volutpat est velit egestas dui id ornare arcu. Aliquam vestibulum morbi blandit cursus risus at ultrices. Nibh sed pulvinar proin gravida hendrerit lectus. Faucibus ornare suspendisse sed nisi lacus sed viverra tellus in. Pellentesque id nibh tortor id aliquet lectus proin nibh nisl. Aenean et tortor at risus viverra adipiscing at in. Iaculis urna id volutpat lacus laoreet non curabitur gravida.")
                .author("나루토")
                .createdTime(LocalDateTime.now())
                .updatedTime(LocalDateTime.now())
                .build();
        postService.savePost(post2);
    }
}
