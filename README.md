# graphql-api-springboot-mongo
 A simple [GraphQL REST API](https://techinjektion.com/crud-api-graphql-spring-boot-mongodb/) built using Spring Boot and MongoDB.
 
 ![GraphQL PAI using Spring Boot](https://techinjektion.com/content/images/2020/05/image-38.png)
 
 The API schema is defined below:
 
 ```
 schema {
    query: Query
    mutation: Mutation
}

type Post {
    id: String
    content: String
    likedBy: [User]
    comments: [String]
    createdAt: String
    lastModified: String
    version: Int
}

type User {
    username: String
    name: String
    email: String
}

type Query {
    post(id : String!): Post
    allPosts : [Post]
}

type Mutation {
    createPost(input: PostInput!) : Post
    deletePost(id : String!) : Boolean
    updatePost(input: PostInput!) : Post
    likePost(postId: String!, user: UserInput!) : Post
    addComment(postId: String!, comment: String!) : Post
}

input PostInput {
    id: String
    content: String
}

input UserInput {
    username: String
    name: String
    email: String
}

 ```
 
 Check out my blog post for the full tutorial. https://techinjektion.com/crud-api-graphql-spring-boot-mongodb/
