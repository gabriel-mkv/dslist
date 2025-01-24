package com.devgabrel.dslist.projections;

public interface GameMinProjection { // Interface de projeção para dados de jogo.
    
    long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}