# Requests for module 12-scheduled-tasks

- **GET**: /api/scheduler/status
  ```bash
  curl -X GET http://localhost:8088/api/scheduler/status
  ```

- **GET**: /api/scheduler/dynamic
  ```bash
  curl -X GET http://localhost:8088/api/scheduler/dynamic
  ```

- **POST**: /api/scheduler/dynamic/fixed-delay
  ```bash
  curl -X POST http://localhost:8088/api/scheduler/dynamic/fixed-delay
  ```

- **POST**: /api/scheduler/dynamic/cron
  ```bash
  curl -X POST http://localhost:8088/api/scheduler/dynamic/cron
  ```

- **POST**: /api/scheduler/dynamic/one-time
  ```bash
  curl -X POST http://localhost:8088/api/scheduler/dynamic/one-time
  ```

- **DELETE**: /api/scheduler/dynamic/{taskName}
  ```bash
  curl -X DELETE http://localhost:8088/api/scheduler/dynamic/{taskName}
  ```
