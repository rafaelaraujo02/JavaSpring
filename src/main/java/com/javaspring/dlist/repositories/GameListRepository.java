package com.javaspring.dlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspring.dlist.entities.Game;
import com.javaspring.dlist.entities.GameList;

//Esta camada será responsável por fazer a busca no BD
public interface GameListRepository extends JpaRepository<GameList, Long>{ //Long é o tipo da PK. Do id, no caso

}
