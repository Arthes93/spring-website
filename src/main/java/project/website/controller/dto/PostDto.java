package project.website.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PostDto {

    @NotEmpty
    private String title;
    private String subtitle;

    @Lob
    private String content;
}
