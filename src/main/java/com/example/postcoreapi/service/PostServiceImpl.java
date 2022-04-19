package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostRequest;
import com.example.postcoreapi.model.PostResponse;
import com.example.postcoreapi.repository.PostEntity;
import com.example.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepository postRepository;
    @Override
    public PostResponse createPost(PostRequest postRequest) {
        postRequest.setPostId(UUID.randomUUID().toString());
        postRequest.setPostRecepientId(UUID.randomUUID().toString());
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        PostEntity postEntity=modelMapper.map(postRequest,PostEntity.class);
        postRepository.save(postEntity);
        return modelMapper.map(postEntity,PostResponse.class);
    }

    @Override
    public PostResponse updatePost(PostRequest postRequest) {



        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PostEntity postEntity=modelMapper.map(postRequest,PostEntity.class);

        PostEntity dbEntity=postRepository.getPostEntitiesByPostId(postRequest.getPostId());
        postEntity.setId(dbEntity.getId());

        postEntity=postRepository.save(postEntity);


        return modelMapper.map(postEntity,PostResponse.class);
    }

    @Override
    public List<PostResponse> getAllPosts() {

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return postRepository.getPostEntitiesBy().stream()
                .map(postEntity -> modelMapper.map(postEntity,PostResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostResponse> getPostsByClientId(String clientId) {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return postRepository.getPostEntitiesByClientId(clientId).stream()
                .map(postEntity -> modelMapper.map(postEntity,PostResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse getPostById(String postId) {

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        PostEntity postEntity=postRepository.getPostEntitiesByPostId(postId);

        return modelMapper.map(postEntity,PostResponse.class);
    }

    @Override
    public void deletePostById(String postId) {
        postRepository.deletePostEntityByPostId(postId);

    }
}
