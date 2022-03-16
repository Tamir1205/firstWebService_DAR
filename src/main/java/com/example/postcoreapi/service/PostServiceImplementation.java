package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
@Service
public class PostServiceImplementation implements postService{
    private static HashMap<String, PostModel> PostMap=new HashMap<>();
    static {
        PostModel firstPost=new PostModel(UUID.randomUUID().toString(),UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),"Adidas T-shirt","On the way",
                "Tamirlan","Shiderbayev",
                "tamirlan@gmail.com","Madiyar","Maripbekov");
        PostModel secondPost=new PostModel(UUID.randomUUID().toString(),UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),"Nike sneakers","On the way",
                "Tamirlan","Shiderbayev",
                "tamirlan@gmail.com","Dimash","Sayatov");
        PostModel thirdPost=new PostModel(UUID.randomUUID().toString(),UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),"Reebok sport suit","going to stock",
                "Aldiyar","Abenov",
                "aldik@gmail.com","Kayrat","Kerenov");
        PostMap.put(firstPost.getPostId(),firstPost);
        PostMap.put(secondPost.getPostId(),secondPost);
        PostMap.put(thirdPost.getPostId(),thirdPost);

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

//    @Override
//    public String checking(String template) {
//        return ;
//    }
//
//    @Override
//    public String checking(String template) {
//        return template;
//    }


}
