package com.peli;

import java.io.*;
import java.util.Scanner;

public class App {
    static Scanner sc;
    static Cave cave;

    static void addMonster() {
        System.out.println("Anna hirviön tyyppi:");
        String nimi = sc.nextLine();
        System.out.println("Anna hirviön elämän määrä numerona:");
        int hp = Integer.parseInt(sc.nextLine());
        cave.addMonster(new Monster(nimi, hp));
    }

    static void attackMonster() {
        cave.listMonsters();
        System.out.println("Valitse hirviö, johon hyökätä");
        int index = Integer.parseInt(sc.nextLine()) -1;
        cave.attackMonster(index);
    }

    static void saveGame() {
        try {
            System.out.println("Anna tiedoston nimi:");
            String filename = sc.nextLine();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(cave);
            out.close();
            System.out.println("Peli tallennettu tiedostoon " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void loadGame() {
        try {
            System.out.println("Anna tiedoston nimi:");
            String filename = sc.nextLine();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            cave = (Cave) in.readObject();
            in.close();
            System.out.println("Peli ladattu!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ){
        sc = new Scanner(System.in);

        Cave cave;

        System.out.println("Syötä pelaajan nimi:");
        Player player = new Player(sc.nextLine());
        cave = new Cave(player);
        App.cave = cave;

        boolean exit = false;
        while(!exit){
            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");

            int valinta = Integer.parseInt(sc.nextLine());

            switch(valinta){
                case 1:
                    addMonster();
                    break;
                case 2:
                    cave.listMonsters();
                    break;

                case 3:
                    attackMonster();
                    break;

                case 4:
                    saveGame();
                    break;

                case 5:
                    loadGame();
                    break;

                case 0:
                    System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                    exit = true;
                    break;

                default:
                    System.out.println("Syöte oli väärä");
            }
        }

        sc.close();
    }
}