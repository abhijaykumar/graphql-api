package com.techinjektion.graphqlapi.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.techinjektion.graphqlapi.error.PostNotFoundException;
import com.techinjektion.graphqlapi.input.PostInput;
import com.techinjektion.graphqlapi.model.Post;
import com.techinjektion.graphqlapi.model.User;
import com.techinjektion.graphqlapi.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {

    private final PostRepository postRepository;

    public Post createPost(PostInput input) {
        Post post = Post.builder()
                .content(input.getContent())
                .likedBy(new ArrayList<User>())
                .comments(new ArrayList<String>())
                .build();
        return postRepository.save(post);
    }

    public Post updatePost(PostInput input) {
        Post post = postRepository.findById(input.getId())
                .orElseThrow(() -> new PostNotFoundException("Post to update was not found",
                        input.getId().toString()));
        post.setContent(input.getContent());
        return postRepository.save(post);
    }

    public boolean deletePost(String id) {
        postRepository.deleteById(new ObjectId(id));
        return true;
    }

    public Post likePost(String postId, User user) {
        Post post = postRepository.findById(new ObjectId(postId))
                .orElseThrow(() -> new PostNotFoundException("Post to like was not found", postId));
        post.getLikedBy().add(user);
        return postRepository.save(post);
    }

    public Post addComment(String postId, String comment) {
        Post post = postRepository.findById(new ObjectId(postId))
                .orElseThrow(() -> new PostNotFoundException("Post to comment was not found", postId));
        post.getComments().add(comment);
        return postRepository.save(post);
    }

}
