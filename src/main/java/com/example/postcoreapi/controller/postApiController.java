package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.service.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class postApiController {
    @Autowired
    private postService postService;
    @PostMapping
    public PostModel createPost(@Valid @RequestBody PostModel postModel){
        return  postService.createPost(postModel);
    }
    @DeleteMapping("/{postId}")
    public  PostModel deletePost(@PathVariable String postId){
        return postService.deletePost(postId);
    }
    @PutMapping("/{postId}")
    public PostModel updatePost(@PathVariable String postId ,@Valid @RequestBody PostModel postModel){
        return postService.updatePost(postId,postModel);

    }
    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId){
        return postService.getPostById(postId);
    }
    @GetMapping("/all")
    public List<PostModel> getAllPosts(){
        return postService.getAllPosts() ;
    }
    @GetMapping("/check")
    public void InitialCheck(){
          System.out.println("It is working");
    }
//    @ResponseBody
//    @RequestMapping(value="/controller", method=GET)
//    @GetMapping("/check")
//    public String checking()
//    {return  "Program is working"; }

}
