package com.devgabrel.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Define como uma entidade JPA.
@Table(name = "tb_game_list") // Mapeia para a tabela "tb_game_list".
public class GameList {

    @Id // Define a chave primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Chave primária gerada automaticamente.
    private long id;
    private String name; // Nome da lista.

    public GameList() { // Construtor padrão.
    }
    
    public GameList(long id, String name) { // Construtor com argumentos.
        this.id = id;
        this.name = name;
    }

    public long getId() { // Retorna o ID.
        return id;
    }

    public void setId(long id) { // Define o ID.
        this.id = id;
    }

    public String getName() { // Retorna o nome.
        return name;
    }

    public void setName(String name) { // Define o nome.
        this.name = name;
    }

    @Override
    public int hashCode() { // Calcula o hash code com base no ID.
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) { // Compara objetos com base no ID.
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GameList other = (GameList) obj;
        if (id != other.id)
            return false;
        return true;
    }
}