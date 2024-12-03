package com.malb.maze.model;

public class History {
    int id;
    int idPlayer;
    int score;
    String keys; //Guardar las ID de las key
    String coins;
    String doors;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
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
