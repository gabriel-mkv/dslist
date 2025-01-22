package com.devgabrel.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devgabrel.dslist.dto.GameDTO;
import com.devgabrel.dslist.dto.GameMinDTO;
import com.devgabrel.dslist.entities.Game;
import com.devgabrel.dslist.projections.GameMinProjection;
import com.devgabrel.dslist.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> listDto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return listDto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> listDto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return listDto;
    }
}
