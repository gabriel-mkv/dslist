# DSlist
> API de Coleções de Jogos

## Descrição

DSList é uma API Rest desenvolvida durante o Intensivão Java Spring sob orientação do professor Nélio Alves, evento organizado pela [DevSuperior](https://devsuperior.com.br/).

A API Rest funciona com base em coleções ordenadas de jogos. Cada coleção exibe jogos diferentes. Os jogos são armazenados em um banco de dados, e a API recupera e retorna os dados para a aplicação web. É possível reordenar os jogos na coleção, e a API atualiza e salva as alterações no banco de dados.

## Tecnologias

- **Java**
- **Spring boot**
- **Maven**
- **JPA / Hibernate**
- **Docker**
- **H2**
- **Postgresql**
- **Postman**

## Modelo de domínio

![Modelo de domínio](/src/main/resources/dslist-model.png)

## Endpoints

| Método | Endpoint                     | Descrição                                                              | Parâmetros                                         | Exemplo de Requisição                                              | Exemplo de Resposta                                                             |
| ------ | ---------------------------- | ---------------------------------------------------------------------- | -------------------------------------------------- | ----------------------------------------------------------------- | ------------------------------------------------------------------------------ |
| GET    | `/games`                     | Lista todos os jogos                                      | Nenhum                                             | `curl https://api.exemplo.com/games`                                | `[{"id": 1, "title": "...", "year": ..., ...}, {"id": 2, "title": "...", "year": ..., ...}]`         |
| GET    | `/games/{id}`                     | Lista todas as informações do jogo do id repassado                                    |       `id` (path param)                                       | `curl https://api.exemplo.com/games/1`                                | `[{"id": 1, "title": "...", "year": ..., "plataform": "...", ...}, {"id": 2, "title": "...", "year": ..., "plataform": "...", ...}]`         |
| GET    | `/lists`                     | Lista todas as listas de jogos                                         | Nenhum                                             | `curl https://api.exemplo.com/lists`                                | `[{"id": 1, "name": "Aventura", ...}, {"id": 2, "name": "Jogos de plataforma", ...}]`         |
| GET    | `/lists/{listId}/games`        | Lista todos os jogos em uma lista específica                            | `listId` (path param)                               | `curl https://api.exemplo.com/lists/1/games`                          | `[{"id": 10, "title": "...", "imgUrl": "...", ...}, {"id": 20, "title": "...", "imgUrl": "...", ...}]`        |
| POST   | `/lists/{listId}/replacement` | Move um jogo dentro de uma lista                                      | `listId` (path param), `sourceIndex`, `destinationIndex` (body)  | `curl -X POST -H "Content-Type: application/json" -d '{"sourceIndex": 0, "destinationIndex": 2}' https://api.exemplo.com/lists/1/replacement` | `null` (sem conteúdo na resposta)                                           |                                  | `null` (sem conteúdo na resposta)                                                                                                    |