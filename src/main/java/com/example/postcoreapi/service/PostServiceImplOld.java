package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
@Service
public class PostServiceImplOld implements postServiceOld{
    private static HashMap<String, PostModel> PostMap=new HashMap<>();
    static {
        PostModel firstPost=new PostModel(UUID.randomUUID().toString(),
                "be6e2e90-967e-48dc-9b7b-23f38921dd68",
                "84f273a2-f62f-4940-ba68-b0af64088f65",
                "Adidas T-shirt",
                "On the way",
                "Aldiyar","Shabdarov",
                "isatay@gmail.com",
                "Astana a.k.a Nur-Sultan");

        PostModel secondPost=new PostModel(UUID.randomUUID().toString(),
                "84f273a2-f62f-4940-ba68-b0af64088f65",
                "be6e2e90-967e-48dc-9b7b-23f38921dd68",
                "Nike sneakers",
                "On the way",
                "Tamirlan","Shiderbayev",
                "tamirlan@gmail.com",
                "Almaty");
        PostMap.put(firstPost.getPostId(),firstPost);
        PostMap.put(secondPost.getPostId(),secondPost);
    }

    @Override
    public PostModel createPost(PostModel postModel) {
       postModel.setPostId(UUID.randomUUID().toString());
        return PostMap.put(postModel.getPostId(),postModel);
    }

    @Override
    public PostModel deletePost(String postId) {
    return  PostMap.remove(postId);

    }

    @Override
    public PostModel updatePost(String postId, PostModel postModel) {
    postModel.setPostId(postId);
    return PostMap.put(postModel.getPostId(),postModel);
    }

    @Override
    public PostModel getPostById(String postId) {
        return PostMap.get(postId);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(PostMap.values());
    }

//


}
