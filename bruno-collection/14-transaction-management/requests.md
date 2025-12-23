# Requests for module 14-transaction-management

- **POST**: /api/transfer
    public String transfer(@RequestParam Long from, @RequestParam Long to, @RequestParam BigDecimal amount
  ```bash
  curl -X POST http://localhost:8088/api/transfer
    public String transfer(@RequestParam Long from, @RequestParam Long to, @RequestParam BigDecimal amount
  ```

- **POST**: /api/transfer/new-transaction
  ```bash
  curl -X POST http://localhost:8088/api/transfer/new-transaction
  ```
