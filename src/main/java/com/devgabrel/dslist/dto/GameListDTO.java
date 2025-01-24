package com.devgabrel.dslist.dto;

import com.devgabrel.dslist.entities.GameList;

public class GameListDTO {
    
    private long id;
    private String name;

    public GameListDTO() { // Construtor padrão.
    }

    public GameListDTO(GameList entity) { // Construtor que recebe GameList e inicializa os campos.
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public long getId() { // Retorna o ID.
        return id;
    }

    public String getName() { // Retorna o nome.
        return name;
    }
}