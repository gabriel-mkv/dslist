package com.devgabrel.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable // Define como um tipo embutido.
public class BelongingPK {
    
    @ManyToOne // Define relacionamento muitos-para-um com Game.
    @JoinColumn(name = "game_id") // Coluna de junção na tabela.
    private Game game; // Referência para a entidade Game.

    @ManyToOne // Define relacionamento muitos-para-um com GameList.
    @JoinColumn(name = "list_id") // Coluna de junção na tabela.
    private GameList list; // Referência para a entidade GameList.

    public BelongingPK() { // Construtor padrão.
    }

    public BelongingPK(Game game, GameList list) { // Construtor com argumentos.
        this.game = game;
        this.list = list;
    }

    public Game getGame() { // Retorna a entidade Game.
        return game;
    }

    public void setGame(Game game) { // Define a entidade Game.
        this.game = game;
    }

    public GameList getList() { // Retorna a entidade GameList.
        return list;
    }

    public void setList(GameList list) { // Define a entidade GameList.
        this.list = list;
    }

    @Override
    public int hashCode() { // Calcula o hash code com base em Game e GameList.
        return Objects.hash(game, list);
    }

    @Override
    public boolean equals(Object obj) { // Compara objetos com base em Game e GameList.
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BelongingPK other = (BelongingPK) obj;
        if (game == null) {
            if (other.game != null)
                return false;
        } else if (!game.equals(other.game))
            return false;
        if (list == null) {
            if (other.list != null)
                return false;
        } else if (!list.equals(other.list))
            return false;
        return true;
    }
}