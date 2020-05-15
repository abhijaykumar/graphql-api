package com.techinjektion.graphqlapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("post")
public class Post {
    ObjectId id;
    String content;
    List<User> likedBy;
    List<String> comments;
    @Version
    private Long version;
    @CreatedDate
    private DateTime createdAt;
    @LastModifiedDate
    private DateTime lastModified;
}
