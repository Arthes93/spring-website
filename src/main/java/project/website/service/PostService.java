package project.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.website.domain.Post;
import project.website.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post getPost(Long idx){
        Post post = postRepository.findById(idx).orElse(null);
        return post;
    }

    public List<Post> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    public void savePost(Post post){
        postRepository.save(post);
    }
}
