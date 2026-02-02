package com.peli;

import java.io.Serializable;

public class Monster implements Serializable {
    private static final long serialVersionUID = 1L;

    String type;
    int health;

    public Monster(String type, int health) {
        this.type = type;
        this.health = health;
    }

    public void printInfo(int number) {
        System.out.println(number + 1 + ": " + type + " / " + health + "HP");
    }

    public boolean takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(type + " kuoli!");
            return true;
        } else {
            System.out.println(type + " hirviöllä on " + health + " elämää jäljellä.");
            return false;
        }
    }
    
}
