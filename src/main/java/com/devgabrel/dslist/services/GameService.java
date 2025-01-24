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

@Service // Define como um serviço do Spring.
public class GameService {
    
    @Autowired // Injeta GameRepository.
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Transação de leitura.
    public GameDTO findById(Long id){ // Busca um jogo por ID.
        Game result = gameRepository.findById(id).get(); // Busca o jogo pela entidade.
        GameDTO dto = new GameDTO(result); // Converte para DTO.
        return dto;
    }

    @Transactional(readOnly = true) // Transação de leitura.
    public List<GameMinDTO> findAll(){ // Busca todos os jogos.
        List<Game> result = gameRepository.findAll(); // Busca todos os jogos pela entidade.
        List<GameMinDTO> listDto = result.stream().map(x -> new GameMinDTO(x)).toList(); // Converte para DTO.
        return listDto;
    }

    @Transactional(readOnly = true) // Transação de leitura.
    public List<GameMinDTO> findByList(long listId){ // Busca jogos por lista.
        List<GameMinProjection> result = gameRepository.searchByList(listId); // Busca os jogos pela projeção.
        List<GameMinDTO> listDto = result.stream().map(x -> new GameMinDTO(x)).toList(); // Converte para DTO.
        return listDto;
    }
}