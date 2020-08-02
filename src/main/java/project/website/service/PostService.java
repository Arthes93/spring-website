package project.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.website.domain.Post;
import project.website.repository.PostRepository;

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
}
