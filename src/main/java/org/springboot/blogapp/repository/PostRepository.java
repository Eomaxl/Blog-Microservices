package org.springboot.blogapp.repository;

import org.springboot.blogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PostRepository extends JpaRepository<Post, Long>{

}
