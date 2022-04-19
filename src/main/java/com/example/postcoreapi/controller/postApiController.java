package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostRequest;
import com.example.postcoreapi.model.PostResponse;
import com.example.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class postApiController {
    private final PostService postService;

    public postApiController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostResponse createPost(@RequestBody  PostRequest postRequest){
        return postService.createPost(postRequest);
    }
    @PutMapping
    public PostResponse updatePost(@RequestParam String postId, @RequestBody PostRequest postRequest){
        postRequest.setPostId(postId);
        return postService.updatePost(postRequest);
    }
    @GetMapping
    public PostResponse getPostById(@RequestParam String postId){
        return postService.getPostById(postId);
    }
    @GetMapping("/{clientId}")
    public List<PostResponse> getPostsByClientId(@PathVariable String clientId){
        return postService.getPostsByClientId(clientId);
    }
    @GetMapping("/all")
    public List<PostResponse> getAllPosts(){
        return postService.getAllPosts();
    }



    @DeleteMapping
    public void deletePostById(@RequestParam String postId){
        postService.deletePostById(postId);
    }
}
