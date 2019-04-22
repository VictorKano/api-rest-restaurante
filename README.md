# api-rest-restaurante

Api Rest para o cadastro e manutenção de restaurantes com Spring Boot 2.1.4, Maven 3.6.0, JPA, H2 Database.

Documentação com Javadoc, disponível em:
https://github.com/VictorKano/javadoc-api-rest-restaurante

Documentação interativa da API com Swagger UI disponível em:
https://api-rest-restaurante.herokuapp.com/swagger-ui.html#/restaurante45end45point

## Rodar localmente
### 1 - Clonar o repositório

```
git clone https://github.com/VictorKano/api-rest-restaurante.git
```


### 2- Através do console entrar no diretório do projeto


### 3- Compilar e executar o projeto usando o Maven

  ```
  mvnw package
  javar -jar target/apirest-0.0.1-SNAPSHOT.jar
  ```

O app irá rodar em: http://localhost:8080

## Explorar APIs REST

```
GET /restaurants
GET /restaurants/{id}
POST /restaurants
DELETE /restaurants
PUT /restaurants
```

Você pode testar entrando em http://localhost:8080/swagger-ui.html,
ou usando o Postman: https://www.getpostman.com/downloads/.
