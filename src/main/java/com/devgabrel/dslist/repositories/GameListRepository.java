package com.devgabrel.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devgabrel.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{ // Repositório para GameList, usando JPA.
    
    @Modifying // Indica que a query modifica o banco de dados.
    @Query(nativeQuery = true,
        value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId") // Query SQL nativa para atualizar posição.
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition); // Atualiza a posição de um jogo em uma lista.

}