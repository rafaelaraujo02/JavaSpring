package com.javaspring.dlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaspring.dlist.dto.GameDTO;
import com.javaspring.dlist.dto.GameMinDTO;
import com.javaspring.dlist.entities.Game;
import com.javaspring.dlist.entities.GameList;
import com.javaspring.dlist.projections.GameMinProjection;
import com.javaspring.dlist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	//Aqui estou fazendo uma instancia de GameRepository
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		
		Game result = gameRepository.findById(id).get(); //buscar do BD o game
		GameDTO dto = new GameDTO(result); //converter o game buscado para DTO
		return dto;
	}
	
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
