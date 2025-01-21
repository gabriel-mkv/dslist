package com.devgabrel.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgabrel.dslist.dto.GameMinDTO;
import com.devgabrel.dslist.entities.Game;
import com.devgabrel.dslist.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> listDto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return listDto;
    }
}
