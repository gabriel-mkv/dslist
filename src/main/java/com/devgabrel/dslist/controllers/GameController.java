package com.devgabrel.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgabrel.dslist.dto.GameDTO;
import com.devgabrel.dslist.dto.GameMinDTO;
import com.devgabrel.dslist.services.GameService;

@RestController // Define esta classe como um controlador REST.
@RequestMapping(value = "/games") // Mapeia requisições para "/games".
public class GameController {
    
    @Autowired // Injeta a dependência GameService.
    private GameService gameService;

    @GetMapping(value = "/{id}") // Mapeia GET para "/games/{id}".
    public GameDTO findById(@PathVariable long id){ // Busca um jogo por ID.
        GameDTO result = gameService.findById(id); // Chama o serviço para buscar o jogo.
        return result; // Retorna o jogo encontrado.
    }

    @GetMapping // Mapeia GET para "/games".
    public List<GameMinDTO> findAll(){ // Lista todos os jogos (dados resumidos).
        List<GameMinDTO> result = gameService.findAll(); // Chama o serviço para buscar a lista de jogos.
        return result; // Retorna a lista de jogos.
    }
}