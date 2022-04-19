package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.service.postServiceOld;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deprecated/post")
public class postApiControllerOld {
    private final Environment env;

    private final postServiceOld postServiceOld;

    public postApiControllerOld(Environment env, com.example.postcoreapi.service.postServiceOld postService) {
        this.env = env;
        this.postServiceOld = postService;
    }

    @PostMapping
    public PostModel createPost(@Valid @RequestBody PostModel postModel) {
        return postServiceOld.createPost(postModel);
    }

    @DeleteMapping("/{postId}")
    public PostModel deletePost(@PathVariable String postId) {
        return postServiceOld.deletePost(postId);
    }

    @PutMapping("/{postId}")
    public PostModel updatePost(@PathVariable String postId, @Valid @RequestBody PostModel postModel) {
        return postServiceOld.updatePost(postId, postModel);
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postServiceOld.getPostById(postId);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postServiceOld.getAllPosts();
    }

    @GetMapping("/check")
    public String postCheck() {
        return "it is working at " + env.getProperty("local.server.port");
    }


}
