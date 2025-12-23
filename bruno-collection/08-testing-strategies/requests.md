# Requests for module 08-testing-strategies

- **GET**: /api/products
    public List<Product> getAllProducts(
  ```bash
  curl -X GET http://localhost:8088/api/products
    public List<Product> getAllProducts(
  ```

- **GET**: /api/products/{id}
  ```bash
  curl -X GET http://localhost:8088/api/products/{id}
  ```

- **POST**: /api/products
    public ResponseEntity<Product> createProduct(@RequestBody Product product
  ```bash
  curl -X POST http://localhost:8088/api/products
    public ResponseEntity<Product> createProduct(@RequestBody Product product
  ```

- **DELETE**: /api/products/{id}
  ```bash
  curl -X DELETE http://localhost:8088/api/products/{id}
  ```
