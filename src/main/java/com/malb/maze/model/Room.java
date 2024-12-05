package com.malb.maze.model;

public class Room {
    int id;
    int N;
    int W;
    int E;
    int S;
    int itemCoin;
    int itemKey;
    int idMaze;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getW() {
        return W;
    }

    public void setW(int w) {
        W = w;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }

    public int getItemCoin() {
        return itemCoin;
    }

    public void setItemCoin(int itemCoin) {
        this.itemCoin = itemCoin;
    }

    public int getItemKey() {
        return itemKey;
    }

    public void setItemKey(int itemKey) {
        this.itemKey = itemKey;
    }

    public int getIdMaze() {
        return idMaze;
    }

    public void setIdMaze(int idMaze) {
        this.idMaze = idMaze;
    }
}
