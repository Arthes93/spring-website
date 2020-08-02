package project.website.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    private String subtitle;

    private String author;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    @Lob
    private String content;

    @Builder
    public Post(Long idx, String title, String subtitle, String author, String content, LocalDateTime createdTime, LocalDateTime updatedTime){
        this.idx = idx;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.content = content;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }
}
