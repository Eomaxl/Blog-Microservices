package org.springboot.blogapp.service;

import org.springboot.blogapp.payload.PostDto;
import org.springboot.blogapp.payload.PostResponse;
import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize);
    PostDto getPostById(Long id);

    PostDto updatePost(PostDto postDto, Long id);

    void deletePost(Long id);
}
