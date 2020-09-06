package project.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Post getPostByIdx(Long idx){
        Post post = postRepository.findById(idx).orElse(null);
        return post;
    }

    public Page<Post> getAllPosts(Pageable pageable){
        if(pageable.getPageNumber() <= 0){
            pageable = PageRequest.of(0, pageable.getPageSize(), Sort.Direction.DESC, "idx");
        }else{
            pageable = PageRequest.of(pageable.getPageNumber()-1, pageable.getPageSize(), Sort.Direction.DESC, "idx");
        }
        Page<Post> posts = postRepository.findAll(pageable);
        return posts;
    }

    public void savePost(Post post){
        postRepository.save(post);
    }
}
