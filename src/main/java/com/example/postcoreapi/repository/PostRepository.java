package com.example.postcoreapi.repository;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity,Long> {

    PostEntity getPostEntitiesByPostId(String postId);

    List<PostEntity> getPostEntitiesBy();

    List<PostEntity> getPostEntitiesByClientId(String clientId);

    @Transactional
    void deletePostEntityByPostId(String postId);



}
