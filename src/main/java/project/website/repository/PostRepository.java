package project.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.website.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
