package com.devgabrel.dslist.dto;

import com.devgabrel.dslist.entities.Game;
import com.devgabrel.dslist.projections.GameMinProjection;

public class GameMinDTO {

    private long id;
    private String title;
    private int year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() { // Construtor padrão.
    }

    public GameMinDTO(long id, String title, int year, String imgUrl, String shortDescription) { // Construtor com todos os atributos.
        this.id = id;
        this.title = title;
        this.year = year;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
    }

    public GameMinDTO(GameMinProjection projection) { // Construtor que recebe uma projeção GameMinProjection.
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public GameMinDTO(Game entity){ // Construtor que recebe a entidade Game.
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public long getId() { // Retorna o ID.
        return id;
    }

    public String getTitle() { // Retorna o título.
        return title;
    }

    public int getYear() { // Retorna o ano.
        return year;
    }

    public String getImgUrl() { // Retorna a URL da imagem.
        return imgUrl;
    }

    public String getShortDescription() { // Retorna a descrição curta.
        return shortDescription;
    }
}