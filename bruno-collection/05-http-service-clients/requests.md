# Requests for module 05-http-service-clients

- **GET**: /api/posts
    public List<PostDTO> getAllPosts(
  ```bash
  curl -X GET http://localhost:8088/api/posts
    public List<PostDTO> getAllPosts(
  ```

- **GET**: /api/posts/{id}
  ```bash
  curl -X GET http://localhost:8088/api/posts/{id}
  ```

- **GET**: /api/posts/reactive
  ```bash
  curl -X GET http://localhost:8088/api/posts/reactive
  ```

- **GET**: /api/posts/reactive/{id}
  ```bash
  curl -X GET http://localhost:8088/api/posts/reactive/{id}
  ```

- **POST**: /api/posts
    public PostDTO createPost(@RequestBody PostDTO post
  ```bash
  curl -X POST http://localhost:8088/api/posts
    public PostDTO createPost(@RequestBody PostDTO post
  ```
