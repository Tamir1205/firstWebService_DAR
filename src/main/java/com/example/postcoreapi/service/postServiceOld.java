package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;

import java.util.List;

public interface postServiceOld {
    PostModel createPost(PostModel postModel);
    PostModel deletePost(String postId);
    PostModel updatePost(String postId,PostModel postModel);
    PostModel getPostById(String postId);
    List<PostModel> getAllPosts();
}
