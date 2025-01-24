package com.devgabrel.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devgabrel.dslist.dto.GameListDTO;
import com.devgabrel.dslist.entities.GameList;
import com.devgabrel.dslist.repositories.GameRepository;
import com.devgabrel.dslist.repositories.GameListRepository;
import com.devgabrel.dslist.projections.GameMinProjection;

@Service // Define como um serviço do Spring.
public class GameListService {
    
    @Autowired // Injeta GameListRepository.
    private GameListRepository gameListRepository;

    @Autowired // Injeta GameRepository.
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Transação de leitura.
    public List<GameListDTO> findAll(){ // Busca todas as listas de jogos.
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> listDto = result.stream().map(x -> new GameListDTO(x)).toList(); // Converte para DTO.
        return listDto;
    }

    @Transactional // Transação com escrita.
    public void move(long listId, int sourceIndex, int destinationIndex) { // Move um jogo em uma lista.
        List<GameMinProjection> list = gameRepository.searchByList(listId); // Busca jogos da lista.

        GameMinProjection obj = list.remove(sourceIndex); // Remove o jogo da posição de origem.
        list.add(destinationIndex, obj); // Adiciona o jogo na posição de destino.

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; // Calcula o menor índice.
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex; // Calcula o maior índice.

        for (int i = min; i <= max; i++) { // Atualiza a posição dos jogos afetados.
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}