package com.devgabrel.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.devgabrel.dslist.entities.Game;

public class GameDTO {
    
    private long id;
    private String title;
    private int year;
    private String genre;
    private String platforms;
    private double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO() { // Construtor padrão.
    }

    public GameDTO(Game entity) { // Construtor que copia propriedades de Game.
        BeanUtils.copyProperties(entity, this);
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
}