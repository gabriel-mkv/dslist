package com.devgabrel.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Define como uma entidade JPA.
@Table(name = "tb_game") // Mapeia para a tabela "tb_game".
public class Game {
    
    @Id // Define a chave primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Chave primária gerada automaticamente.
    private long id;
    private String title;

    @Column(name = "release_year") // Mapeia a coluna "release_year".
    private int year;
    private String genre;
    private String platforms;
    private double score;
    private String imgUrl;

    @Column(columnDefinition = "TEXT") // Define o tipo da coluna como TEXT.
    private String shortDescription;
    
    @Column(columnDefinition = "TEXT") // Define o tipo da coluna como TEXT.
    private String longDescription;

    public Game() { // Construtor padrão.
    }

    public Game(long id, String title, int year, String genre, String platforms, double score, String imgUrl, String shortDescription, String longDescription) { // Construtor com argumentos.
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public long getId() { // Retorna o ID.
        return id;
    }

    public void setId(long id) { // Define o ID.
        this.id = id;
    }

    public String getTitle() { // Retorna o título.
        return title;
    }

    public void setTitle(String title) { // Define o título.
        this.title = title;
    }

    public int getYear() { // Retorna o ano de lançamento.
        return year;
    }

    public void setYear(int year) { // Define o ano de lançamento.
        this.year = year;
    }

    public String getGenre() { // Retorna o gênero.
        return genre;
    }

    public void setGenre(String genre) { // Define o gênero.
        this.genre = genre;
    }

    public String getPlatforms() { // Retorna as plataformas.
        return platforms;
    }

    public void setPlatforms(String platforms) { // Define as plataformas.
        this.platforms = platforms;
    }

    public double getScore() { // Retorna a pontuação.
        return score;
    }

    public void setScore(double score) { // Define a pontuação.
        this.score = score;
    }

    public String getImgUrl() { // Retorna a URL da imagem.
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) { // Define a URL da imagem.
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() { // Retorna a descrição curta.
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) { // Define a descrição curta.
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() { // Retorna a descrição longa.
        return longDescription;
    }

    public void setLongDescription(String longDescription) { // Define a descrição longa.
        this.longDescription = longDescription;
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
        Game other = (Game) obj;
        if (id != other.id)
            return false;
        return true;
    }
}