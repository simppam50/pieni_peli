package com.peli;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean attack(Monster target) {
        System.out.println(name + " hyökkää " + target.type + " hirviöön!");
        return target.takeDamage(10);
    }

}