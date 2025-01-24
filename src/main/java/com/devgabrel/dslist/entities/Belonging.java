package com.devgabrel.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity // Define como uma entidade JPA.
@Table(name = "tb_belonging") // Mapeia para a tabela "tb_belonging".
public class Belonging {
    
    @EmbeddedId // Define a chave primária composta.
    private BelongingPK id = new BelongingPK(); // Chave primária composta.

    private Integer position; // Posição do jogo na lista.

    public Belonging() { // Construtor padrão.
    }

    public Belonging(Game game, GameList list, Integer position) { // Construtor com argumentos.
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    public BelongingPK getId() { // Retorna a chave primária.
        return id;
    }

    public void setId(BelongingPK id) { // Define a chave primária.
        this.id = id;
    }

    public Integer getPosition() { // Retorna a posição.
        return position;
    }

    public void setPosition(Integer position) { // Define a posição.
        this.position = position;
    }

    @Override
    public int hashCode() { // Calcula o hash code com base na chave primária.
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) { // Compara objetos com base na chave primária.
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Belonging other = (Belonging) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}