package project.website.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.website.domain.Post;
import project.website.repository.PostRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    PostService postService;

    @Autowired
    public PostServiceTest(PostService postService){
        this.postService = postService;
    }

    @Test
    @Transactional
    public void 데이터_삽입_테스트(){
        //given
        Post post = Post.builder()
                .title("test")
                .subtitle("test")
                .content("test")
                .build();

        //when
        postService.savePost(post);

        //then
        assertThat(post.getTitle()).isEqualTo("test");
        assertThat(post.getSubtitle()).isEqualTo("test");
        assertThat(post.getContent()).isEqualTo("test");
    }

    @Test
    @Transactional
    public void 데이터_가져오기() throws Exception{
        //given
        Post post = Post.builder()
                .title("test")
                .subtitle("test")
                .content("test")
                .build();
        postService.savePost(post);

        //when
        Post getPost = postService.getPostByIdx(post.getIdx());

        //then
        assertThat(getPost.getTitle()).isEqualTo(post.getTitle());
    }
}