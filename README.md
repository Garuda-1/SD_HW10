# Software Design
## HW 10: Reactive app

Задание выполнено на базе реактивного фреймворка **Spring 5 WebFlux**. 

Спецификация API в формате OpenAPI:

```yaml
  /goods:
    get:
      summary: "GET goods"
      operationId: "getAllGoodsForUser"
      parameters:
      - name: "userId"
        in: "query"
        required: true
        schema:
          type: "number"
          format: "int64"
      responses:
        "200":
          description: "OK"
    post:
      summary: "POST goods"
      operationId: "addGood"
      responses:
        "200":
          description: "OK"
---
  /user:
    post:
      summary: "POST user"
      operationId: "registerUser"
      parameters:
      - name: "login"
        in: "query"
        required: true
        schema:
          type: "string"
      - name: "currency"
        in: "query"
        required: true
      responses:
        "200":
          description: "OK"
```

Для запуска требуется пустая или ранее накаченная по подходящей схеме база данных PostgreSQL на порту 8081. Чтобы быстро
ее получить, можно воспользоваться `docker/docker-compose.yaml`.