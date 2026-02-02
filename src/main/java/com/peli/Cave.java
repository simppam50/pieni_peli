package com.peli;

import java.io.Serializable;
import java.util.ArrayList;

public class Cave implements Serializable {
    private static final long serialVersionUID = 1L;
    
    Player player;
    ArrayList<Monster> monsters = new ArrayList<>();
    
    public Cave(Player player) {
        this.player = player;
    }
    
    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void listMonsters(){
        if (monsters.isEmpty()) {
            System.out.println("Luola on tyhjä.");
            return;
        }

        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).printInfo(i);
        }
        
    }

    public void attackMonster(int index) {
        if (index < 0 || index >= monsters.size()) 
            return;

        Monster m = monsters.get(index);
        boolean isDead = player.attack(m);

        if (isDead) {
            monsters.remove(index);
        }
    }
    
}
