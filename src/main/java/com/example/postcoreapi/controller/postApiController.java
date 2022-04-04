package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.service.postService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class postApiController {
    private final Environment env;

    private final postService postService;

    public postApiController(Environment env, com.example.postcoreapi.service.postService postService) {
        this.env = env;
        this.postService = postService;
    }

    @PostMapping
    public PostModel createPost(@Valid @RequestBody PostModel postModel) {
        return postService.createPost(postModel);
    }

    @DeleteMapping("/{postId}")
    public PostModel deletePost(@PathVariable String postId) {
        return postService.deletePost(postId);
    }

    @PutMapping("/{postId}")
    public PostModel updatePost(@PathVariable String postId, @Valid @RequestBody PostModel postModel) {
        return postService.updatePost(postId, postModel);
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/check")
    public String postCheck() {
        return "it is working at " + env.getProperty("local.server.port");
    }


}
