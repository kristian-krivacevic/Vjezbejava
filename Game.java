package com.udg.edu.me;

import java.util.ArrayList;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<String> eventLog;

    public Game(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();
        this.eventLog = new ArrayList<>();
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        eventLog.add("ADDED: " + e.toString());
    }

    //provjera preklapanja
    public boolean checkCollision(Player p, Enemy e) {
        return p.getX() < e.getX() + e.getWidth() &&
               p.getX() + p.getWidth() > e.getX() &&
               p.getY() < e.getY() + e.getHeight() &&
               p.getY() + p.getHeight() > e.getY();
    }

    //smanjuje health i dodaje dogadjaje
    public void decreaseHealth(Player p, Enemy e) {
        int oldHP = p.getHealth();
        int newHP = oldHP - e.getDamage();
        if (newHP < 0) newHP = 0;
        p.setHealth(newHP);
        eventLog.add("HIT: " + p.getName() + " by " + e.getType() + " for " + e.getDamage() + " -> HP " + oldHP + " -> " + newHP);
    }

    public ArrayList<Enemy> findByType(String query) {
        ArrayList<Enemy> result = new ArrayList<>();
        query = query.toLowerCase().trim();
        for (Enemy e : enemies) {
            if (e.getType().contains(query)) {
                result.add(e);
            }
        }
        return result;
    }

    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> list = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                list.add(e);
            }
        }
        return list;
    }

    public void resolveCollisions() {
        for (Enemy e : collidingWithPlayer()) {
            decreaseHealth(player, e);
        }
    }

    public void printEventLog() {
        System.out.println("\n=== EVENT LOG ===");
        for (String e : eventLog) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Player p = new Player("   player   1 ", 10, 5, 32, 32, 85);
        Game game = new Game(p);

        Enemy e1 = new Enemy("orc", 8, 5, 16, 16, 20);
        game.addEnemy(e1);

        String data = "Goblin;12,5;16x16;20";
        String[] parts = data.split(";");
        String type = parts[0].trim();
        String[] pos = parts[1].trim().split(",");
        String[] size = parts[2].trim().split("x");
        int dmg = Integer.parseInt(parts[3].trim());

        Enemy e2 = new Enemy(type,
                Integer.parseInt(pos[0]),
                Integer.parseInt(pos[1]),
                Integer.parseInt(size[0]),
                Integer.parseInt(size[1]),
                dmg);
        game.addEnemy(e2);

        System.out.println("Igrac: " + p);
        System.out.println("Neprijatelji:");
        for (Enemy e : game.enemies) {
            System.out.println(" - " + e);
        }

        System.out.println("\nPretraga (\"gob\"):");
        for (Enemy e : game.findByType("gob")) {
            System.out.println(" * " + e);
        }

        System.out.println("\nPrije borbe:");
        for (Enemy e : game.collidingWithPlayer()) {
            System.out.println("Sudar: " + e);
        }

        System.out.println("\n HP prije: " + p.getHealth());
        game.resolveCollisions();
        System.out.println("HP posle: " + p.getHealth());

        game.printEventLog();
    }
}
