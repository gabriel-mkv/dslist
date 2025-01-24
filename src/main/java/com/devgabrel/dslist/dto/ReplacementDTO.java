package com.devgabrel.dslist.dto;

public class ReplacementDTO {

    private int sourceIndex; // Índice de origem do item.
    private int destinationIndex; // Índice de destino do item.

    public int getSourceIndex() { // Retorna o índice de origem.
        return sourceIndex;
    }
    public void setSourceIndex(int sourceIndex) { // Define o índice de origem.
        this.sourceIndex = sourceIndex;
    }
    public int getDestinationIndex() { // Retorna o índice de destino.
        return destinationIndex;
    }
    public void setDestinationIndex(int destinationIndex) { // Define o índice de destino.
        this.destinationIndex = destinationIndex;
    }
}