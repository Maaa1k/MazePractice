package com.malb.maze.model;

public class Game {
    int id;
    int idPlayer;
    int idScore;
    int idMaze;
    String username;
    String coinScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public int getIdScore() {
        return idScore;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public int getIdMaze() {
        return idMaze;
    }

    public void setIdMaze(int idMaze) {
        this.idMaze = idMaze;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCoinScore() {
        return coinScore;
    }

    public void setCoinScore(String coinScore) {
        this.coinScore = coinScore;
    }
}
