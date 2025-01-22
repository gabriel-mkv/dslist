package com.devgabrel.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devgabrel.dslist.dto.GameListDTO;
import com.devgabrel.dslist.entities.GameList;
import com.devgabrel.dslist.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> listDto = result.stream().map(x -> new GameListDTO(x)).toList();
        return listDto;
    }
}
