package org.springboot.blogapp.service.impl;

import org.springboot.blogapp.entity.Post;
import org.springboot.blogapp.payload.PostDto;
import org.springboot.blogapp.payload.PostResponse;
import org.springboot.blogapp.repository.PostRepository;
import org.springboot.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        System.out.println("Inside the postservice createPost method");
        // convert DTO to entity
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);
        // convert entity to DTO
        PostDto postResponse = mapToDto(newPost);
        return postResponse;
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize){
        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Post> allPosts = postRepository.findAll(pageable);
        List<PostDto> content = allPosts.stream().map((post)->mapToDto(post)).toList();
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(allPosts.getNumber());
        postResponse.setPageSize(allPosts.getSize());
        postResponse.setLast(allPosts.isLast());
        postResponse.setTotalPages(allPosts.getTotalPages());
        postResponse.setTotalElements(allPosts.getNumberOfElements());
        return postResponse;
    }

    @Override
    public PostDto getPostById(Long id){
        Post post = postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post not found with id: " + id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post not found with id: " + id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
    private PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        return post;
    }
}
