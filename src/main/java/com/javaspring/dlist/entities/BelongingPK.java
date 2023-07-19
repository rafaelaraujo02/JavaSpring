package com.javaspring.dlist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable //Serve para encapsular dois atributos em uma classe só. Game e GameList
public class BelongingPK {

	/*
	 * Configurar o relacionamento das tabelas para receber as chaves estrangeiras
	 * As tabelas Game e GameList estão se relacionando através da tabela Belonging(pertence). Como mostra abaixo
	 * Game * - belonging - *GameList. Muitos games pra um Belonging e muitos GameList pra um Belonging 
	*/
	@ManyToOne
	@JoinColumn(name = "game_id") //Setando o nome das chaves estrangeiras
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList gameList;
	
	public BelongingPK() {
		
	}

	public BelongingPK(Game game, GameList gameList) {
		
		this.game = game;
		this.gameList = gameList;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getGameList() {
		return gameList;
	}

	public void setGameList(GameList gameList) {
		this.gameList = gameList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, gameList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(gameList, other.gameList);
	}
	
	
}
