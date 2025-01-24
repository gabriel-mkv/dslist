package com.devgabrel.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devgabrel.dslist.dto.GameListDTO;
import com.devgabrel.dslist.dto.GameMinDTO;
import com.devgabrel.dslist.dto.ReplacementDTO;
import com.devgabrel.dslist.services.GameListService;
import com.devgabrel.dslist.services.GameService;

@RestController // Define como um controlador REST.
@RequestMapping(value = "/lists") // Mapeia requisições para "/lists".
public class GameListController {
    
    @Autowired // Injeta GameListService.
    private GameListService gameListService;

    @Autowired // Injeta GameService.
    private GameService gameService;

    @GetMapping // Mapeia GET para "/lists".
    public List<GameListDTO> findAll(){ // Lista todas as listas de jogos.
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games") // Mapeia GET para "/lists/{listId}/games".
    public List<GameMinDTO> findByList(@PathVariable long listId){ // Lista jogos de uma lista específica.
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement") // Mapeia POST para "/lists/{listId}/replacement".
    public void move(@PathVariable long listId, @RequestBody ReplacementDTO body){ // Move um jogo em uma lista.
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}