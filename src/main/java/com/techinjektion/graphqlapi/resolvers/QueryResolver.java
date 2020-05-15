package com.techinjektion.graphqlapi.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.techinjektion.graphqlapi.error.PostNotFoundException;
import com.techinjektion.graphqlapi.model.Post;
import com.techinjektion.graphqlapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    private final PostRepository postRepository;

    public Post post(String id) {
        return postRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new PostNotFoundException("Post not found", id));
    }

    public Iterable<Post> allPosts() {
        return postRepository.findAll();
    }

}
