package com.devgabrel.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.devgabrel.dslist.entities.Game;
import com.devgabrel.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{ // Repositório para Game, usando JPA.
	
    @Query(nativeQuery = true, value = """ 
		SELECT tb_game.id, tb_game.title, tb_game.release_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""") // Query SQL nativa para buscar jogos por lista.
    List<GameMinProjection> searchByList(Long listId); // Busca jogos de uma lista, retornando projeção.
}