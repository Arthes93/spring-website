package project.website.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    private String subtitle;

    @Lob
    private String content;

    @Builder
    public Post(Long idx, String title, String subtitle, String content){
        this.idx = idx;
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
    }
}
